package com.ajitesh.learn.vendingmachine.model.state;

public class WaitingForCoin implements State {
    private final Message message;

    public WaitingForCoin(Message message) {
        this.message = message;
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
