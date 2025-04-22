package com.garage.service;

import com.garage.entity.Entretien;
import com.garage.repository.EntretienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EntretienServiceImpl implements IEntretienService {
    @Autowired
    private EntretienRepository entretienRepository;

    private Entretien getEntretien(long id){
        return entretienRepository.findById(id).orElseThrow(()->new RuntimeException("aucungarage n'a zt"));
    }
    @Override
    public Entretien saveEntretien(Entretien entretien) {
        return  entretienRepository.save(entretien);
    }

    @Override
    public Collection<Entretien> listeEntretiens() {
        return List.of(entretienRepository.getAllEntretiens().toArray(new Entretien[0]));
    }

    @Override
    public Entretien getOneEntretien(Long id) {
        return entretienRepository.getEntretiensByisDeleted(false);
    }

    @Override
    public Entretien updateEntretien(Long id, Entretien entretien) {
        Entretien existing = getEntretien(id);
        existing.setDate(entretien.getDate());
        existing.setDescription(entretien.getDescription());
        existing.setPrix(entretien.getPrix());
        existing.setEmploye(entretien.getEmploye());
        existing.setCar(entretien.getCar());

        return entretienRepository.save(existing);
    }

    @Override
    public void deleteEntretien(Long id) {
        Entretien existing= getEntretien(id);
        existing.setDeleted(true);

        entretienRepository.save(existing);
    }
}
