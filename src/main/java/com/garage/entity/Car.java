package com.garage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table (name="car")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class Car implements Serializable {
    @Id
    private String immatriculation;

    @Column(nullable = false,length =100)
    private String marque;
    @Column(nullable = false,length = 150)
    private String modele;
    @Column(nullable = false,length = 25)
    private String etat;

    private boolean isDeleted;
}