package com.lucasangelo.controller;

import com.lucasangelo.model.Message;
import com.lucasangelo.service.MessageService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
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
    public Response getMessage() {
        Message message = messageService.getMessage();

        CacheControl cacheControl = new CacheControl();
        cacheControl.setMaxAge(3600);
        cacheControl.setPrivate(true);

        return Response.ok(message)
                .cacheControl(cacheControl)
                .build();
    }
}
