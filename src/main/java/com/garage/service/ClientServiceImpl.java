package com.garage.service;

import com.garage.entity.Client;
import com.garage.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ClientServiceImpl implements IClientService{
    @Autowired
    private ClientRepository clientRepository;
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private Client getClient(Long id){
        return clientRepository.getReferenceById(id);
    }
    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Collection<Client> listeClients() {
        return clientRepository.getAllClients();
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client getOneClient(Long id) {
        Client c = getClient(id);
        Boolean test=c.isDeleted();
        if (test = true){
            throw new RuntimeException("Aucun Resultat");
        }
        return c;
    }

    @Override
    public Client updateClient(Long id, Client client) {
        Client existing = getClient(id);
        existing.setMatricule(client.getMatricule());
        existing.setPrenom(client.getPrenom());
        existing.setNom(client.getNom());
        existing.setEmail(client.getEmail());
        existing.setTelephone(client.getTelephone());
        existing.setStatus(client.getStatus());

        return clientRepository.save(existing);
    }

    @Override
    public void deleteClient(Long id) {
        Client existing = getClient(id);
        existing.setDeleted(true);

        clientRepository.save(existing);

    }
}
