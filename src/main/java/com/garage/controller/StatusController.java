package com.garage.controller;

import com.garage.entity.Status;
import com.garage.service.StatusServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/status")
@RequiredArgsConstructor
public class StatusController {
    private StatusServiceImpl statusService;


    @Autowired
    public StatusController(StatusServiceImpl statusService) {
        this.statusService = statusService;
    }


    @GetMapping
    public ResponseEntity<Collection<Status>> listeStatus() {
        Collection<Status> listCar = statusService.listeStatuses();
        return ResponseEntity.ok(listCar);
    }

    @GetMapping("/{immatriculation}")
    public ResponseEntity<Status> RechercheCar(@PathVariable long id) {
        Status status = statusService.getOneStatus(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(status);
    }

    @PostMapping
    public ResponseEntity<Status> ajouterStatus(@RequestBody Status st) {
        Status status = statusService.saveStatus(st);
        return ResponseEntity.status(HttpStatus.CREATED).body(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> modifierStatus(@PathVariable long id, @RequestBody Status st) {
        Status status = statusService.updateStatus(id, st);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(status);
    }

    @DeleteMapping(" /{id}")
    public ResponseEntity<Object> suprimerStatus(@PathVariable long id) {
        statusService.deleteStatus(id);
        return ResponseEntity.noContent().build();


    }
}