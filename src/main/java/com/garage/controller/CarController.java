package com.garage.controller;


import com.garage.entity.Car;
import com.garage.service.CarServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }


    @GetMapping
    public ResponseEntity<Collection<Car>> listeCar(){
        Collection<Car> listCar = carService.listeCar();
        return ResponseEntity.ok(listCar);
    }

    @GetMapping("/{immatriculation}")
    public ResponseEntity<Car> RechercheCar(@PathVariable String immatriculation){
        Car car = carService.getOneCar(immatriculation);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(car);
    }

    @PostMapping
    public ResponseEntity<Car> ajouterCar(@RequestBody Car car){
        Car c = carService.saveCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }

    @PutMapping("/{immatriculation}")
    public ResponseEntity<Car> modifierCar(@PathVariable String immatriculation, @RequestBody Car c){
        Car car = carService.updateCar(immatriculation,c);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(car);
    }

    @DeleteMapping(" /{immatriculation}")
    public ResponseEntity<Object> suprimerCar(@PathVariable String immatriculation){
        carService.deleteCar(immatriculation);
        return ResponseEntity.noContent().build();
    }


}
