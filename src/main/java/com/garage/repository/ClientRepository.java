package com.garage.repository;

import com.garage.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("select c from Client c where c.isDeleted = false")
    Collection<Client> getAllClients();

    //Client getClientById(Long id);
}
