package com.lucasangelo.service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import jakarta.ejb.embeddable.EJBContainer;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class MessageServiceTest {

    private static final String EXPECTED_MESSAGE = "Hello, World!";

    private static EJBContainer ejbContainer;

    @BeforeClass
    public static void setUp() {
        ejbContainer = EJBContainer.createEJBContainer();
    }

    @AfterClass
    public static void tearDown() {
        if (Objects.nonNull(ejbContainer))
            ejbContainer.close();
    }
    
    @Test
    public void testGetAndCheckMessage() throws Exception {
        // given
        final var service = (MessageService) ejbContainer.getContext().lookup("java:global/samplejaxrsget/MessageService!com.lucasangelo.service.MessageService");

        // when
        final var message = service.getMessage();

        // then
        assertEquals(EXPECTED_MESSAGE, message.getText());
    }

}