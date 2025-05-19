package com.garage.entity;

import com.garage.entity.enummeration.StatusClient;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client extends Personne {
    @Column(nullable = false,length = 150)
    private StatusClient statusClient;

    @OneToMany(mappedBy = "client")
    private List<Car> cars;



    @ManyToOne
    @JoinColumn()
    private Status status;
}
