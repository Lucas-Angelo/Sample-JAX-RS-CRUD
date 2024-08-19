package com.lucasangelo.service;

import com.lucasangelo.model.Message;
import java.util.List;
import java.util.ArrayList;
import jakarta.ejb.Stateless;

@Stateless
public class MessageService {

    private List<Message> messages = new ArrayList<>();

    public MessageService() {
        messages.add(new Message("Hello, World!", 1L));
        messages.add(new Message("Hello, World 2!", 2L));
    }

    public Message getMessage(long id) {
        for (Message m : messages) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        return new Message("Message not found", 0L);
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void removeMessage(Message message) {
        messages.remove(message);
    }

    public void updateMessage(Message message) {
        for (Message m : messages) {
            if (m.getId().equals(message.getId())) {
                m.setText(message.getText());
            }
        }
    }
}