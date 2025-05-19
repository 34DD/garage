/*package com.garage.service;

import com.garage.entity.Etat;
import com.garage.repository.EtatRepository;

import java.util.Collection;
import java.util.List;

public class EtatServiceImpl implements IEtatService{
    private static EtatRepository etatRepository;

    private Etat getEtat(long id){
        return etatRepository.findById(id).orElseThrow(()->new RuntimeException("aucun Valeur trouvé pour etat"));
    }
    @Override
    public Etat saveEtat(Etat etat) {
        return etatRepository.save(etat);
    }

    @Override
    public Etat getOneEtat(Long id) {
        return getEtat(id);
    }

    @Override
    public Collection<Etat> listeEtats() {
        return List.of();
    }

    @Override
    public Etat updateEtat(Long id, Etat etat) {
        Etat existing = getEtat(id);
        existing.setLibelle(etat.getLibelle());

        return etatRepository.save(existing);
    }
    @Override
    public void deleteEtat(Long id) {
        Etat existing = getEtat(id);
        existing.setDeleted(true);

        etatRepository.save(existing);

    }
}
*/