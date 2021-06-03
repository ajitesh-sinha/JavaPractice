package com.ajitesh.learn.vendingmachine.model.state;

public class TransactionAborted implements State {
    private final Message message;

    public TransactionAborted(Message message) {
        this.message = message;
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
