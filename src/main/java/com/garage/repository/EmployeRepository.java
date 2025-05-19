package com.garage.repository;

import com.garage.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    @Query("select emp from Employe emp where emp.isDeleted=false")
    Collection<Employe> getAllEmployes();

    Employe getEmployeByisDeleted(boolean isDeleted);
}
