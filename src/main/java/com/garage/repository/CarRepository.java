package com.garage.repository;

import com.garage.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CarRepository extends JpaRepository<Car,String>  {
    @Query("select c from Car c where c.isDeleted = false")
    Collection<Car> getAllCars();

    String immatriculation(String immatriculation);
}
