package com.ajitesh.learn.vendingmachine.model;

public enum Product implements Item{
    SnickersBar(40), PopTarts(30), UncleChips(65),
    GranolaBar(70), LaysTomato(15), LaysOnion(12),
    Pepsi(21), DietCoke(23), MountainDew(34), RedBull(54);

    private final int price;
    Product(int price) {
        this.price = price;
    }

    public int getValue() {
        return price;
    }
}
