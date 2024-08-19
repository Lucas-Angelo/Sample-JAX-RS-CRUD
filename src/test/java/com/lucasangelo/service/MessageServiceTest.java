package com.lucasangelo.service;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageServiceTest {

    private static final String EXPECTED_MESSAGE = "Hello, World!";
    private static MessageService service;

    @BeforeClass
    public static void setup() {
        service = new MessageService();
    }

    @Test
    public void testGetAndCheckMessage() {
        // when
        final var message = service.getMessage();

        // then
        assertEquals(EXPECTED_MESSAGE, message.getText());
    }
}