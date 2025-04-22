package com.garage.service;

import com.garage.entity.Client;

import java.util.Collection;

public interface IClientService {
    Client saveClient (Client client);
    Collection<Client> listeClients();
    Client getOneClient(Long id);
    Client updateClient(Long id,Client client);
    void deleteClient(Long id);
}
