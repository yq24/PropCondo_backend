package com.flagcamp.backend.dao;

import com.flagcamp.backend.entity.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 根据messageId查询message
     * @param messageId
     * @return message
     */
    @Override
    public Message getMessage(int messageId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // now retrieve/read from database using the primary key
        Message message = currentSession.get(Message.class, messageId);
        return message;
    }

    /**
     * 查询用户收到的所有message
     * @param username
     * @return 用户收到的所有message
     */
    @Override
    public List<Message> receivedMessages(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        // create a query
        Query<Message> theQuery = currentSession.createQuery("from Message where userTo =: username", Message.class);
        // execute query and get result list
        List<Message> messages = theQuery.getResultList();
        // return the results
        return messages;
    }

    /**
     * 查询用户发送的所有message
     * @param username
     * @return 用户发送的所有message
     */
    @Override
    public List<Message> sentMessages(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        // create a query
        Query<Message> theQuery = currentSession.createQuery("from Message where userFrom =: username", Message.class);
        // execute query and get result list
        List<Message> messages = theQuery.getResultList();
        // return the results
        return messages;
    }

    /**
     * 添加一条message
     * @param message
     */
    @Override
    public void addMessage(Message message) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(message);
    }

    /**
     * 删除一条message
     * @param theId
     */
    @Override
    public void deleteMessage(int theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // delete object with primary key
        Query theQuery = currentSession.createQuery("delete from Message where messageId =:id");
        theQuery.setParameter("id", theId);
        theQuery.executeUpdate();
    }
}
