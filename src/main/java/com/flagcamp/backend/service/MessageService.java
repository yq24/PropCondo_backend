package com.flagcamp.backend.service;

import com.flagcamp.backend.entity.Message;
import com.flagcamp.backend.entity.Post;

import java.util.List;

public interface MessageService {

    Message getMessage(int messageId);

    List<Message> receivedMessages(String username);

    List<Message> sentMessages(String username);

    void addMessage(Message message);

    void deleteMessage(int messageId);

}
