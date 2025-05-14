package com.garage.security.service;

import com.garage.domaine.Role;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(String name);
    Role save(Role role);
}
