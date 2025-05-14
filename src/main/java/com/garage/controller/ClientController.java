package com.garage.controller;


import com.garage.entity.Client;
import com.garage.entity.Client;
import com.garage.service.ClientServiceImpl;
import com.garage.service.ClientServiceImpl;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/clients") 
@RequiredArgsConstructor
public class ClientController {
    private ClientServiceImpl clientService;

    @Autowired
    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<Collection<Client>> listClients(){
        Collection<Client> listClients = clientService.listeClients();
        return ResponseEntity.ok(listClients);
    }
/*
    @GetMapping
    public ResponseEntity<Collection<Client>> listeClient(){
        Collection<Client> listClient = clientService.listeClients();
        return ResponseEntity.ok(listClient);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Client> RechercheClient(@PathVariable Long id){
        ///Client client = clientService.getOneClient(id);
        /*return ResponseEntity.status(HttpStatus.ACCEPTED).body(client);*/
        return clientService.getClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Client> ajouterClient(@RequestBody Client client){
        Client c = clientService.saveClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> modifierClient(@PathVariable Long id, @RequestBody Client c){
        Client client = clientService.updateClient(id,c);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(client);
    }

    @DeleteMapping(" /{id}")
    public ResponseEntity<Object> suprimerClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }


}
