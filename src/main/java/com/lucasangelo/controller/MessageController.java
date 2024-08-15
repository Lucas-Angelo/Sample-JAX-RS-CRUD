package com.lucasangelo.controller;

import com.lucasangelo.model.Message;
import com.lucasangelo.service.MessageService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class MessageController {

    @EJB
    private MessageService messageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage() {
        return messageService.getMessage();
    }

}