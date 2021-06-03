package com.ajitesh.learn.vendingmachine.model;

public enum Coin implements Item {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25), EMPTY(0);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
