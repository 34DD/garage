package com.garage.service;

import com.garage.entity.Employe;
import com.garage.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeServiceImpl implements IEmployeService{
    @Autowired
    private EmployeRepository employeRepository;

    private Employe getEmploye(Long id){
        return employeRepository.getReferenceById(id);
    }


    @Override
    public Employe saveEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Collection<Employe> listeEmployes() {
        return employeRepository.getAllEmployes();
//        return List.of();
    }

    @Override
    public Employe getOneEmploye(Long id) {
        return employeRepository.getEmployeByisDeleted(false);
    }

    @Override
    public Employe updateEmploye(Long id, Employe employe) {
        Employe existing = getEmploye(id);
        existing.setMatricule(employe.getMatricule());
        existing.setPrenom(employe.getPrenom());
        existing.setNom(employe.getNom());
        existing.setEmail(employe.getEmail());
        existing.setTelephone(employe.getTelephone());

        return employeRepository.save(existing);
    }

    @Override
    public void deleteEmploye(Long id) {
        Employe existing = getEmploye(id);
        existing.setDeleted(true);

        employeRepository.save(existing);
    }
}
