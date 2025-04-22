package com.garage.controller;


import com.garage.entity.Entretien;
import com.garage.entity.Entretien;
import com.garage.service.EntretienServiceImpl;
import com.garage.service.EntretienServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/entretiens")
@RequiredArgsConstructor
public class EntretienController {
    private EntretienServiceImpl entretienService;

    @Autowired
    public EntretienController(EntretienServiceImpl entretienService) {
        this.entretienService = entretienService;
    }


   /* @GetMapping
    public ResponseEntity<Collection<Entretien>> listEntretien(){
        Collection<Entretien> listEntretien = entretienService.listeEntretiens();
        return ResponseEntity.ok(listEntretien);
    }*/

    @GetMapping
    public ResponseEntity<Collection<Entretien>> listeEntretien(){
        Collection<Entretien> listEntretien = entretienService.listeEntretiens();
        return ResponseEntity.ok(listEntretien);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entretien> RechercheEntretien(@PathVariable Long id){
        Entretien entretien = entretienService.getOneEntretien(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(entretien);
    }

    @PostMapping
    public ResponseEntity<Entretien> ajouterEntretien(@RequestBody Entretien entretien){
        Entretien c = entretienService.saveEntretien(entretien);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entretien> modifierEntretien(@PathVariable Long id, @RequestBody Entretien c){
        Entretien entretien = entretienService.updateEntretien(id,c);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(entretien);
    }

    @DeleteMapping(" /{id}")
    public ResponseEntity<Object> suprimerEntretien(@PathVariable Long id){
        entretienService.deleteEntretien(id);
        return ResponseEntity.noContent().build();
    }


}