package com.garage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false,length =50)
    private String matricule;
    @Column(nullable = false,length =150)
    private String nom;
    @Column(nullable = false,length =150)
    private String prenom;
    @Column(nullable = false,length = 13)
    private String telephone;
    @Column(nullable = false,length = 255)
    private String email;

    private boolean isDeleted;
}
