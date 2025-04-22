package com.garage.service;

import com.garage.entity.Car;
import com.garage.entity.Etat;
import com.garage.entity.enummeration.Etats;
import com.garage.repository.CarRepository;
import com.garage.repository.EtatRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service
public class CarServiceImpl implements ICarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private EtatRepository etatRepository;

    private Car getCar(String immatriculation) {
        return carRepository.findById(immatriculation).orElseThrow(()->new RuntimeException("Aucun car trouvé"));
    }

    @Override
    public Car saveCar(Car car) {

        Set<String> etats = etatRepository.getEtatByisDeleted(false);
        Set<Etat> listEtats = new HashSet<>();

        if(etats == null){
            Etat etatCar = etatRepository.findByLibelle(Etats.EN_FILE_d_ATTENTE)
                    .orElseThrow(() -> new RuntimeException("Error: Cette etat n'existe pas"));

            listEtats.add(etatCar);
        }else{
            etats.forEach(r -> {
                switch (r){
                    case "Mis à disposition" -> {
                        Etat etatCar = etatRepository.findByLibelle(Etats.Mis_A_DISPOSITION)
                                .orElseThrow(() -> new RuntimeException("Error: Ce role n'existe pas"));
                        listEtats.add(etatCar);
                    }
                    case "Prix en Charge" -> {
                        Etat etatCar = etatRepository.findByLibelle(Etats.PRIS_EN_CHARGE)
                                .orElseThrow(() -> new RuntimeException("Error: Ce role n'existe pas"));
                        listEtats.add(etatCar);
                    }
                    default -> {
                        Etat etatCar = etatRepository.findByLibelle(Etats.EN_FILE_d_ATTENTE)
                                .orElseThrow(() -> new RuntimeException("Error: Ce role n'existe pas"));
                        listEtats.add(etatCar);
                    }
                }
            });
        }
        car.setEtat((Etat) listEtats);
        return carRepository.save(car);
    }

    @Override
    public Collection<Car> listeCar() {
    //*** return List.of(carRepository.getAllCars().toArray(new Car[0]));*/
        return carRepository.getAllCars();
        }

    @Override
    public Car updateCar(String immatriculation, Car car) {

        Car existing = getCar(immatriculation);
        existing.setMarque(car.getMarque());
        existing.setModele(car.getModele());

        Set<String> etats = etatRepository.getEtatByisDeleted(true);

        etats.forEach(r -> {
            switch (r){
                case "Mis à disposition" -> {
                    Etat etatCar = etatRepository.findByLibelle(Etats.Mis_A_DISPOSITION)
                            .orElseThrow(() -> new RuntimeException("Error: Ce role n'existe pas"));
                }
                case "Prix en Charge" -> {
                    Etat etatCar = etatRepository.findByLibelle(Etats.PRIS_EN_CHARGE)
                            .orElseThrow(() -> new RuntimeException("Error: Ce role n'existe pas"));
                }
                default -> {
                    Etat etatCar = etatRepository.findByLibelle(Etats.EN_FILE_d_ATTENTE)
                            .orElseThrow(() -> new RuntimeException("Error: Ce role n'existe pas"));
                }
            }
        });
        existing.setEtat((Etat) etats);

        return carRepository.save(existing);
    }

    @Override
    public void deleteCar(String immatriculation) {
        Car existing = getCar(immatriculation);
        existing.setDeleted(true);

        carRepository.save(existing);
    }

    @Override
    public Car getOneCar(String immatriculation){
    //**    return List.of(carRepository.getAllCars().toArray(new Car[0]));*/
        return getCar(immatriculation);
    }

}
