package com.garage.service;

import com.garage.entity.Status;

import java.util.Collection;

public interface IStatusService {

    Status saveStatus (Status status);
    Collection<Status> listeStatuses();
    Status getOneStatus(Long id);
    Status updateStatus(Long id,Status status);
    void deleteStatus(Long id);
}