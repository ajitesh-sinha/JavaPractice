package com.ajitesh.learn.vendingmachine.model.state;

import lombok.Data;

@Data
public class Message {
    private String text;

    public Message(String text) {
        this.text = text;
    }
}
