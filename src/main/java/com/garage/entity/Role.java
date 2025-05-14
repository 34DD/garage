package com.garage.entity;

import jakarta.persistence.*;
import lombok.*;

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
}

