package com.garage.service;

import com.garage.entity.Role;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(String name);
    Role saveRole(Role role);
}
