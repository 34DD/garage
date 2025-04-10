package com.garage.service;

import com.garage.entity.Car;
import com.garage.repository.CarRepository; 
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service
public class CarService implements ICarService {
    @Autowired
    private CarRepository carRepository;

    private Car getCar(String immatriculation) {
        Car existing = carRepository.findById(immatriculation).orElseThrow(()->new RuntimeException("Aucun car trouvé"));
        return existing;
    }
    @Override
    public Car saveCar(Car car) {
        return (Car) carRepository.save(car);
    }

    @Override
    public Collection<Car> listeCar() {
    /** return List.of(carRepository.getAllCars().toArray(new Car[0]));*/
        return carRepository.getAllCars();
        }

    @Override
    public Car updateCar(String immatriculation, Car car) {

        Car existing = getCar(immatriculation);
        existing.setMarque(car.getMarque());
        existing.setModele(car.getModele());
        existing.setEtat(car.getEtat());

        return carRepository.save(existing);
    }

    @Override
    public void deleteCar(String immatriculation) {
        Car existing = getCar(immatriculation);
        existing.setDeleted(true);
        carRepository.delete(existing);

    }

}
