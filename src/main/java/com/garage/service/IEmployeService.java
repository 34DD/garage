package com.garage.service;

import com.garage.entity.Employe;

import javax.swing.text.html.parser.Entity;
import java.util.Collection;

public interface IEmployeService {
    Employe saveEmploye (Employe employe);
    Collection<Employe> listeEmployes();
    Employe getOneEmploye(Long id);
    Employe updateEmploye(Long id,Employe employe);
    void deleteEmploye(Long id);
}
