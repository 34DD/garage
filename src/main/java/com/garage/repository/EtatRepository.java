package com.garage.repository;

import com.garage.entity.Etat;
import com.garage.entity.enummeration.Etats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface EtatRepository extends JpaRepository<Etat,Long> {
    Optional<Etat> findByLibelle(Etats libelle);

    Set<String> getEtatByisDeleted(Boolean isDeleted);
    //Long id(Long id);
}
