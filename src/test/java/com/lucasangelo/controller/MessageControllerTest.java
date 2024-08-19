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
}
