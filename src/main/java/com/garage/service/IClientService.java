package com.garage.service;

import com.garage.entity.Client;

import java.util.Collection;
import java.util.Optional;

public interface IClientService {
    Client saveClient (Client client);
    Collection<Client> listeClients();
    Optional<Client> getClientById(Long id);
    Client getOneClient(Long id);
    Client updateClient(Long id,Client client);
    void deleteClient(Long id);
}
