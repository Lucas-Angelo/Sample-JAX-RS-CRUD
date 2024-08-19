package com.lucasangelo.controller;

import com.lucasangelo.model.Message;
import com.lucasangelo.service.MessageService;
import java.util.*;
import jakarta.ejb.EJB;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.CacheControl;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello-world")
public class MessageController {

    @EJB
    private MessageService messageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMessages() {
        List<Message> messages = messageService.getMessages();

        CacheControl cacheControl = new CacheControl();
        cacheControl.setMaxAge(3600);
        cacheControl.setPrivate(true);

        return Response.ok(messages)
                .cacheControl(cacheControl)
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessageById(@PathParam("id") long id) {
        Message message = messageService.getMessage(id);

        return Response.ok(message)
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMessage(Message message) {
        messageService.addMessage(message);

        return Response.ok(message)
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeMessage(@PathParam("id") long id) {
        Message message = messageService.getMessage(id);
        messageService.removeMessage(message);

        return Response.ok(message)
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMessage(Message message) {
        messageService.updateMessage(message);

        return Response.ok(message)
                .build();
    }
}
