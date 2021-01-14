package com.example.zamut.service;

import com.example.zamut.model.*;
import com.example.zamut.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
    
    public void addMessage(Message message) {
    	
    }
}
