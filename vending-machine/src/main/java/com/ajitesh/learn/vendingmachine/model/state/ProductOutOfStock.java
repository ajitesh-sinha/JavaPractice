package com.ajitesh.learn.vendingmachine.model.state;

public class ProductOutOfStock implements State {
    private final Message message;

    public ProductOutOfStock(Message message) {
        this.message = message;
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
