package com.flagcamp.backend.service;

import com.flagcamp.backend.dao.ReservationDao;
import com.flagcamp.backend.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    @Override
    @Transactional
    public Reservation getReservation(int reservationId) {
        return reservationDao.getReservation(reservationId);
    }

    @Override
    @Transactional
    public List<Reservation> getReservations() {
        return reservationDao.getReservations();
    }

    @Override
    @Transactional
    public void addReservation(Reservation reservation) {
        reservationDao.addReservation(reservation);
    }

    @Override
    @Transactional
    public void deleteReservation(int reservationId) {
        reservationDao.deleteReservation(reservationId);
    }
}






