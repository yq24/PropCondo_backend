package com.flagcamp.backend.dao;

import com.flagcamp.backend.entity.Resident;

import java.util.List;

public interface ResidentDAO {

    public List<Resident> getResidents();

    public void saveResident(Resident theResident);

    public Resident getResident(String theId);

    public void deleteResident(String theId);

}