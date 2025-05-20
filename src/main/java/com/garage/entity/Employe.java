package com.garage.entity;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employe {
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
    @Column(nullable = false,length = 250)
    private String email;
    @Column(nullable = false,length = 150)
    private String domicile;
    @Column(nullable = false,length = 25)
    private Double salaire;
    @Column(nullable = false,length = 250)
    private String qualification;

    private boolean isDeleted = false;


    @OneToMany(mappedBy = "employe")
    private List<Entretien> entretiens;

}
