package com.flagcamp.backend.service;

import com.flagcamp.backend.entity.Resident;

import java.util.List;

public interface ResidentService {
    public List<Resident> getResidents();

    public void saveResident(Resident theResident);

    public Resident getResident(String username);

    public void deleteResident(String username);
}
