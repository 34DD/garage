package com.garage.service;

import com.garage.entity.Car;
import com.garage.entity.Client;
import com.garage.entity.Etat;
import com.garage.entity.enummeration.Etats;
import com.garage.repository.CarRepository;
import com.garage.repository.ClientRepository;
import com.garage.repository.EtatRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service
public class CarServiceImpl implements ICarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EtatRepository etatRepository;

    private Car getCar(String immatriculation) {
        return carRepository.findById(immatriculation).orElseThrow(()->new RuntimeException("Aucun car trouvé"));
    }

    @Override
    public Car saveCar(Car car) {
        Set<Etat> etats = etatRepository.getEtatByisDeleted(false);

        Etat etat = etatRepository.findByLibelle(Etats.EN_FILE_D_ATTENTE)
                .orElseThrow(() -> new RuntimeException("Etat par défaut introuvable"));
        car.setEtat(etat);

        Client client = clientRepository.findById(car.getClient().getId())
                .orElseThrow(() -> new RuntimeException("Client introuvable"));
        car.setClient(client);

        return carRepository.save(car);

    }
    @Override
    public Collection<Car> listeCar() {
    //*** return List.of(carRepository.getAllCars().toArray(new Car[0]));*/
        return carRepository.getAllCars();
        }

    @Override
    public Car updateCar(String immatriculation, Car car) {

        Car existing = getCar(immatriculation); // Récupération via immatriculation unique
        existing.setMarque(car.getMarque());
        existing.setModele(car.getModele());
        // Ajoute ici d'autres champs si besoin

        /*Set<Etat> etats = etatRepository.getEtatByisDeleted(false);
        Etat etatCar;

        if (etats == null || etats.isEmpty()) {
            // Aucun état actif => état par défaut
            etatCar = etatRepository.findByLibelle(Etats.EN_FILE_D_ATTENTE)
                    .orElseThrow(() -> new RuntimeException("Erreur : l'état 'En file d'attente' n'existe pas"));
        } else {
            Etats selectedLibelle = etats.iterator().next().getLibelle();

            switch (selectedLibelle) {
                case MIS_A_DISPOSITION -> etatCar = etatRepository.findByLibelle(Etats.MIS_A_DISPOSITION)
                        .orElseThrow(() -> new RuntimeException("Erreur : l'état 'Mis à disposition' n'existe pas"));
                case PRIS_EN_CHARGE -> etatCar = etatRepository.findByLibelle(Etats.PRIS_EN_CHARGE)
                        .orElseThrow(() -> new RuntimeException("Erreur : l'état 'Pris en charge' n'existe pas"));
                default -> etatCar = etatRepository.findByLibelle(Etats.EN_FILE_D_ATTENTE)
                        .orElseThrow(() -> new RuntimeException("Erreur : l'état par défaut n'existe pas"));
            }
        }*/


        Set<Etat> etats = etatRepository.getEtatByisDeleted(false);

        Etat etat = etatRepository.findByLibelle(Etats.EN_FILE_D_ATTENTE)
                .orElseThrow(() -> new RuntimeException("Etat par défaut introuvable"));
        existing.setEtat(etat);

        Client client = clientRepository.findById(car.getClient().getId())
                .orElseThrow(() -> new RuntimeException("Client introuvable"));
        existing.setClient(client);
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
