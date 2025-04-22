package com.garage.service;

import com.garage.entity.Entretien;

import java.util.Collection;

public interface IEntretienService {
    Entretien saveEntretien (Entretien entretien);
    Collection<Entretien> listeEntretiens();
    Entretien getOneEntretien(Long id);
    Entretien updateEntretien(Long id, Entretien entretien);
    void deleteEntretien(Long id);
}
