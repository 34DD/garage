package com.garage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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

    @ManyToOne
    @JoinColumn()
    private Etat etat;

    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "car")
    private List<Entretien> entretiens;

}