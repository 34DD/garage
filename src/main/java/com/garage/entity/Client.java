package com.garage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {
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

    private boolean isDeleted;

    @OneToMany(mappedBy = "client")
    private List<Car> cars;
    

    @ManyToOne
    @JoinColumn()
    private Status status;
}
