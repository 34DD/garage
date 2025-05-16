package com.garage.repository;

import com.garage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Pour rechercher un utilisateur par username
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}

