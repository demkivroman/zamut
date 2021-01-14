package com.example.zamut;

import com.example.zamut.model.*;
import com.example.zamut.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MessageTest {
    @Autowired
    private MessageService messageService;
    @Autowired
    private ConsumerService consumerService;

    @Test
    public void whenCheckGetAllMessages() {
        List<Message> messages = messageService.getAllMessages();
        Assertions.assertEquals(messages.size(), 4);
    }

}
