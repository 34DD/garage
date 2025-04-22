package com.garage.entity;

import com.garage.entity.enummeration.StatusClient;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private StatusClient libelle;
    private boolean isDeleted = false;

}
