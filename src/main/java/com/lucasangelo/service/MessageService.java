package com.lucasangelo.service;

import com.lucasangelo.model.Message;
import jakarta.ejb.Stateless;

@Stateless
public class MessageService {

    private static final String HELLO_WORLD;

    static {
        HELLO_WORLD = "Hello, World!";
    }

    public Message getMessage() {
        return new Message(HELLO_WORLD);
    }
}