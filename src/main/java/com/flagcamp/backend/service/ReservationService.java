package com.flagcamp.backend.service;

import com.flagcamp.backend.entity.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation getReservation(int reservationId);

    List<Reservation> getReservations();

    void addReservation(Reservation reservation);

    void deleteReservation(int reservationId);
}
