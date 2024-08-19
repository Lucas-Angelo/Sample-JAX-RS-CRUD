package com.lucasangelo.controller;

import com.lucasangelo.model.Message;
import com.lucasangelo.service.MessageService;
import jakarta.ws.rs.core.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MessageControllerTest {

    private static final String EXPECTED_MESSAGE = "Hello, World!";
    private static final long EXPECTED_ID = 1L;

    // private static final String EXPECTED_CACHE_CONTROL_HEADER = "Cache-Control";
    // private static final String EXPECTED_CACHE_CONTROL_VALUE = "private, no-transform, max-age=3600";

    @Mock
    private MessageService messageService;

    @InjectMocks
    private MessageController messageController;

    private Message expectedMessage;

    @Before
    public void setUp() {
        expectedMessage = new Message();
        expectedMessage.setText(EXPECTED_MESSAGE);
        expectedMessage.setId(EXPECTED_ID);
    }

    @Test
    public void testGetMessage() {
        // given
        when(messageService.getMessage(EXPECTED_ID)).thenReturn(expectedMessage);

        // when
        Response response = messageController.getMessageById(EXPECTED_ID);
        Message actualMessage = (Message) response.getEntity();

        // then
        assertEquals(EXPECTED_MESSAGE, actualMessage.getText());

        // String cacheControlHeader = response.getHeaderString(EXPECTED_CACHE_CONTROL_HEADER);
        // assertEquals(EXPECTED_CACHE_CONTROL_VALUE, cacheControlHeader);
    }

    @Test
    public void testGetMessageWithInvalidId() {
        // given
        Message errorMessage = new Message();
        errorMessage.setText("Message not found");
        errorMessage.setId(0L);
        when(messageService.getMessage(5L)).thenReturn(errorMessage);

        // when
        Response response = messageController.getMessageById(5L);

        // then
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testAddMessage() {
        // given
        Message newMessage = new Message();
        newMessage.setText("New message");
        newMessage.setId(3L);

        // when
        Response response = messageController.addMessage(newMessage);

        // then
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testUpdateMessage() {
        // given
        Message updatedMessage = new Message();
        updatedMessage.setText("Updated message");
        updatedMessage.setId(3L);

        // when
        Response response = messageController.updateMessage(updatedMessage);

        // then
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testRemoveMessage() {
        // given
        Message messageToRemove = new Message();
        messageToRemove.setText("Updated message");
        messageToRemove.setId(3L);

        // when
        Response response = messageController.removeMessage(messageToRemove.getId());

        // then
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testGetAllMessages() {
        // when
        Response response = messageController.getAllMessages();

        // then
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
}
