package com.flagcamp.backend.service;

import com.flagcamp.backend.dao.MessageDao;
import com.flagcamp.backend.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    // need to inject Post dao
    @Autowired
    private MessageDao messageDao;

    @Override
    @Transactional
    public Message getMessage(int messageId) {
        return messageDao.getMessage(messageId);
    }

    @Override
    @Transactional
    public List<Message> receivedMessages(String username) {
        return messageDao.receivedMessages(username);
    }

    @Override
    @Transactional
    public List<Message> sentMessages(String username) {
        return messageDao.sentMessages(username);
    }

    @Override
    @Transactional
    public void addMessage(Message message) {
        messageDao.addMessage(message);
    }

    @Override
    @Transactional
    public void deleteMessage(int messageId) {
        messageDao.deleteMessage(messageId);
    }
}






