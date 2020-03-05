package com.flagcamp.backend.dao;

import com.flagcamp.backend.entity.Reservation;

import java.util.List;

public interface ReservationDao {

    Reservation getReservation(int reservationId);

    List<Reservation> getReservations();

    void addReservation(Reservation reservation);

    void deleteReservation(int reservationId);

}
