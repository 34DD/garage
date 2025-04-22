package com.garage.repository;

import com.garage.entity.Entretien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Collection;

public interface EntretienRepository extends JpaRepository<Entretien,Long> {

    Entretien findByDate(/*@Param("date")*/ LocalDate date);

    @Query("select entretien from Entretien entretien where entretien.isDeleted = false")
    Collection<Entretien> getAllEntretiens();

    Entretien getEntretiensByisDeleted(boolean deleted);
}
