package com.lucasangelo.service;

import org.junit.BeforeClass;
import org.junit.Test;

import com.lucasangelo.model.Message;

import static org.junit.Assert.assertEquals;

public class MessageServiceTest {

    private static final String EXPECTED_MESSAGE = "Hello, World!";
    private static final long EXPECTED_ID = 1L;
    private static MessageService service;

    @BeforeClass
    public static void setup() {
        service = new MessageService();
    }

    @Test
    public void testGetAndCheckMessage() {
        // when
        var message = service.getMessage(EXPECTED_ID);

        // then
        assertEquals(EXPECTED_MESSAGE, message.getText());
    }

    @Test
    public void testGetAndCheckMessageWithInvalidId() {
        // when
        var message = service.getMessage(0);

        // then
        assertEquals("Message not found", message.getText());
    }

    @Test
    public void testAddMessage() {
        // given
        var message = new Message("Hello, World 3!", 3L);
        var size = service.getMessages().size();

        // when
        service.addMessage(message);

        // then
        assertEquals(size + 1, service.getMessages().size());
    }

    @Test
    public void testRemoveMessage() {
        // given
        var message = new Message("Hello, World 4!", 4L);
        service.addMessage(message);
        var size = service.getMessages().size();

        // when
        service.removeMessage(message);

        // then
        assertEquals(size - 1, service.getMessages().size());
    }

    @Test
    public void testUpdateMessage() {
        // given
        var message = new Message("Hello, World 5!", 5L);
        service.addMessage(message);
        var updatedMessage = new Message("Hello, World 5 Updated!", 5L);

        // when
        service.updateMessage(updatedMessage);

        // then
        assertEquals(updatedMessage.getText(), service.getMessage(5L).getText());
    }
}