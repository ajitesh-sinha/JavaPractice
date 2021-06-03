package com.ajitesh.learn.vendingmachine.model.state;

public class WaitingForNewTransaction implements State {
    private final Message message;

    public WaitingForNewTransaction(Message message) {
        this.message = message;
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
