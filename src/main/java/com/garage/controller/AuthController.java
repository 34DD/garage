package com.garage.controller;

import com.garage.dto.LoginRequest;
import com.garage.dto.LoginResponse;
import com.garage.dto.RegisterRequest;
import com.garage.entity.Role;
import com.garage.entity.User;
import com.garage.repository.RoleRepository;
import com.garage.security.JwtUtil;
import com.garage.service.UserService;
import com.garage.service.UserServiceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;
    

    @Autowired
    private RoleRepository roleRepository;
    

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Endpoint de connexion (Login)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            var user = userService.findByUsername(loginRequest.getUsername()).get();
            var token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(new LoginResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Nom d'utilisateur ou mot de passe incorrect");
        }
    }

    // Endpoint d'inscription (Register)
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        if (userService.findByUsername(registerRequest.getUsername()).isPresent()) {
            // ResponseEntity.status(401).body("Message à affiché");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nom d'utilisateur non diponible");//"Nom d'utilisateur déjà utilisé"
        }

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        Role defaultRole = roleRepository.findByName("USER").orElseThrow(() -> new RuntimeException("Role USER non trouvé"));
        user.setRoles(Set.of(defaultRole));

        userService.saveUser(user);

        return ResponseEntity.ok("Utilisateur enregistré avec succès");
    }
}