package com.ajitesh.learn.vendingmachine.model.state;

public class TransactionComplete implements State {
    private final Message message;

    public TransactionComplete(Message message) {
        this.message = message;
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
