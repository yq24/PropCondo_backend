package com.flagcamp.backend.dao;

import com.flagcamp.backend.entity.Resident;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResidentDAOImpl implements ResidentDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Resident> getResidents() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by id
        Query<Resident> theQuery =
                currentSession.createQuery("from Resident order by user_id",
                        Resident.class);

        // execute query and get result list
        List<Resident> residents = theQuery.getResultList();

        // return the results
        return residents;
    }

    @Override
    public void saveResident(Resident theResident) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the resident ... finally LOL
        currentSession.saveOrUpdate(theResident);

    }

    @Override
    public Resident getResident(int user_id) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Resident theResident = currentSession.get(Resident.class, user_id);

        return theResident;
    }

    @Override
    public void deleteResident(int userId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Resident where user_id =:ResidentId");
        theQuery.setParameter("ResidentId", userId);

        theQuery.executeUpdate();
    }

}











