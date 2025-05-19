package com.garage.controller;

import com.garage.entity.Employe;
import com.garage.entity.Employe;
import com.garage.service.EmployeServiceImpl;
import com.garage.service.EmployeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/Employes")
@RequiredArgsConstructor
public class EmployeController {
    private EmployeServiceImpl employeService;
    @Autowired
    public EmployeController(EmployeServiceImpl employeService) {
        this.employeService = employeService;
    }

/*
    @GetMapping
    public ResponseEntity<Collection<Employe>> listeEmploye(){
        Collection<Employe> listEmploye = employeService.listeEmployes();
        return ResponseEntity.ok(listEmploye);
    }*/

    @GetMapping
    public ResponseEntity<Collection<Employe>> listEmployes(){
        Collection<Employe> listEmployes = employeService.listeEmployes();
        return ResponseEntity.ok(listEmployes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> RechercheEmploye(@PathVariable Long id){
        Employe employe = employeService.getOneEmploye(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employe);
    }

    @PostMapping
    public ResponseEntity<Employe> ajouterEmploye(@RequestBody Employe employe){
        Employe c = employeService.saveEmploye(employe);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> modifierEmploye(@PathVariable Long id, @RequestBody Employe c){
        Employe employe = employeService.updateEmploye(id,c);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employe);
    }

    @DeleteMapping(" /{id}")
    public ResponseEntity<Object> suprimerEmploye(@PathVariable Long id){
        employeService.deleteEmploye(id);
        return ResponseEntity.noContent().build();
    }


}
