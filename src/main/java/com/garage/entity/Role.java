package com.garage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

    @Entity
    @Table(name = "roles")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nom du rôle : exemple ROLE_USER, ROLE_ADMIN
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}