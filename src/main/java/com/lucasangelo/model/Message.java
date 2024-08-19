package com.lucasangelo.model;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private String text;
    private Long id;

    public Message() {
    }

    public Message(String text, Long id) {
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public Long getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{text='" + text + "'}";
    }

}