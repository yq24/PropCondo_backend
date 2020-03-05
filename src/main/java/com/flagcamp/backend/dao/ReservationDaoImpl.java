package com.flagcamp.backend.dao;

import com.flagcamp.backend.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ReservationDaoImpl implements ReservationDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 根据reservationId获取reservation
     * @param reservationId
     * @return
     */
    @Override
    public Reservation getReservation(int reservationId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // now retrieve/read from database using the primary key
        Reservation reservation = currentSession.get(Reservation.class, reservationId);
        return reservation;
    }

    /**
     * 获得所有未过期reservation
     * @return
     */
    @Override
    public List<Reservation> getReservations() {
        Session currentSession = sessionFactory.getCurrentSession();
        // create a query
        Date date = new Date();
        Query<Reservation> theQuery = currentSession.createQuery("from Reservation order by endTime", Reservation.class);
        // execute query and get result list
        List<Reservation> reservations = theQuery.getResultList();
        // return the results
        return reservations;
    }

    /**
     * 增加一条reservation
     * @param reservation
     */
    @Override
    public void addReservation(Reservation reservation) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(reservation);
    }

    /**
     * 删除一条reservation
     * @param theId
     */
    @Override
    public void deleteReservation(int theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // delete object with primary key
        Query theQuery = currentSession.createQuery("delete from Reservation where reservationId =:id");
        theQuery.setParameter("id", theId);
        theQuery.executeUpdate();
    }

}
