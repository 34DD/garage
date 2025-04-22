package com.garage.repository;

import com.garage.entity.Status;
import com.garage.entity.enummeration.StatusClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status,Long> {
    Status getStatusByisDeleted(boolean isDeleted);

    List<Status> findAllByLibelle(StatusClient libelle);

    Optional<Status> findByLibelle(StatusClient libelle)
            ;
    Long id(Long id);
}
