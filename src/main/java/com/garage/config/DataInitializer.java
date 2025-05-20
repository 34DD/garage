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
            // Création du rôle ADMIN si non existant
            if (roleService.findByName("ADMIN").isEmpty()) {
                Role adminRole = new Role();
                adminRole.setName("ADMIN");
                roleService.saveRole(adminRole);
            }

            Role roleUser = roleService.findByName("USER").get();
            Role roleAdmin = roleService.findByName("ADMIN").get();

            // Création d’un utilisateur admin si non existant
            if (userService.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123")); // mot de passe encodé
                admin.setEnabled(true);
                admin.setRoles(Set.of(roleAdmin));
                userService.saveUser(admin);
            }
            
        // Création de l'utilisateur standard
        if (userService.findByUsername("user").isEmpty()) {
            User user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user123"));
            user.setEnabled(true);
            user.setRoles(Set.of(roleUser));
            userService.saveUser(user);
        }
        System.out.println("✅ Utilisateurs et rôles initialisés.");

        };
        
    }
}

