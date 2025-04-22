package com.garage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employe extends Personne {
    @Column(nullable = false,length = 150)
    private String domicile;
    @Column(nullable = false,length = 25)
    private Double salaire;

    private boolean isDeleted = false;

    private String specialite;

    @OneToMany(mappedBy = "employe")
    private List<Entretien> entretiens;

}
