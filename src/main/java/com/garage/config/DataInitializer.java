package com.garage.config;

import com.garage.entity.Role;
import com.garage.entity.User;
import com.garage.service.IRoleService;
import com.garage.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserService userService,
                                      IRoleService roleService,
                                      PasswordEncoder passwordEncoder) {
        return args -> {
            // Création du rôle USER si non existant
            if (roleService.findByName("USER").isEmpty()) {
                Role userRole = new Role();
                userRole.setName("USER");
                roleService.saveRole(userRole);
            }

            Role roleUser = roleService.findByName("USER").get();

            // Création d’un utilisateur admin si non existant
            if (userService.findByUsername("admin").isEmpty()) {
                User user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("admin123")); // mot de passe encodé
                user.setEnabled(true);
                user.setRoles(Set.of(roleUser));
                userService.saveUser(user);
            }
        };
    }
}

