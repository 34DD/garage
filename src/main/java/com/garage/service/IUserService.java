package com.garage.security.service;

import com.garage.security.entity.*;
import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String username);
    User save(User user);
    boolean existsByUsername(String username);
}
