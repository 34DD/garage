package com.garage.repository;

import com.garage.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
    @Query("select p from Personne p where p.isDeleted = false")
    Collection<Personne> getAllPersonne();

    Personne getPersonnesByisDeleted(boolean isDeleted);
}
