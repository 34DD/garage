package com.garage.controller;


import com.garage.entity.Car;
import com.garage.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping
    public ResponseEntity<Collection<Car>> listeCar(){
        Collection<Car> listCar = carService.listeCar();
        return ResponseEntity.ok(listCar);
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

    @DeleteMapping("/cars/{immatriculation}")
    public ResponseEntity<Object> suprimerCar(@PathVariable String immatriculation){
        carService.deleteCar(immatriculation);
        return ResponseEntity.noContent().build();
    }


}
