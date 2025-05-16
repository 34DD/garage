package com.garage.service;

import com.garage.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    User saveUser(User user);
    //boolean existsByUsername(String username);
}
