package com.garage.service;

import com.garage.entity.Car;

import java.util.Collection;

public interface ICarService {

    Car saveCar (Car car);
    Car getOneCar (String immatriculation);
    Collection<Car> listeCar();
    Car updateCar(String immatriculation,Car car);
    void deleteCar(String immatriculation);
}
