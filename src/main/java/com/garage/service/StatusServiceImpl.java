package com.garage.service;

import com.garage.entity.Entretien;
import com.garage.entity.Status;
import com.garage.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StatusServiceImpl implements IStatusService{
    @Autowired
    private StatusRepository statusRepository;

    private Status getStatus(long id) {
        return statusRepository.findById(id).orElseThrow(()->new RuntimeException("Aucun Status trouvé"));
    }

    @Override
    public Status saveStatus(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public Collection<Status> listeStatuses() {
        return List.of(statusRepository.findAll().toArray(new Status[0]));
    }

    @Override
    public Status getOneStatus(Long id) {
        return statusRepository.getStatusByisDeleted(false);
    }

    @Override
    public Status updateStatus(Long id, Status status) {
        Status existing = getStatus(id);
        existing.setLibelle(status.getLibelle());

        return statusRepository.save(existing);
    }

    @Override
    public void deleteStatus(Long id) {
        Status existing = getStatus(id);
        existing.setDeleted(true);

        statusRepository.save(existing);
    }
}
