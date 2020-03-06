package com.flagcamp.backend.service;

import com.flagcamp.backend.dao.ResidentDAO;
import com.flagcamp.backend.entity.Resident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResidentServiceImpl implements ResidentService {

    // need to inject Resident dao
    @Autowired
    private ResidentDAO ResidentDAO;

    @Override
    @Transactional
    public List<Resident> getResidents() {

        return ResidentDAO.getResidents();
    }

    @Override
    @Transactional
    public void saveResident(Resident theResident) {

        ResidentDAO.saveResident(theResident);
    }

    @Override
    @Transactional
    public Resident getResident(String username) {

        return ResidentDAO.getResident(username);
    }

    @Override
    @Transactional
    public void deleteResident(String username) {

        ResidentDAO.deleteResident(username);
    }
}





