package com.flagcamp.backend.dao;

import com.flagcamp.backend.entity.Message;

import java.util.List;

public interface MessageDao {

    Message getMessage(int messageId);

    List<Message> receivedMessages(String username);

    List<Message> sentMessages(String username);

    void addMessage(Message message);

    void deleteMessage(int messageId);

}
