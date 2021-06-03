package com.ajitesh.learn.vendingmachine.model;

import java.util.Map;

public class Inventory {
    private final Map<Product, Integer> products;
    private final Map<Coin, Integer> coins;

    public Inventory(Map<Product, Integer> products, Map<Coin, Integer> coins) {
        this.products = products;
        this.coins = coins;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public boolean isProductInStock(Product product) {
        return products.getOrDefault(product, 0) > 0;
    }

    public void updateStock(Product product) {
        final Integer oldValue = products.get(product);
        products.replace(product, oldValue, oldValue - 1);
    }

    public int getCountOf(Coin coin) {
        return coins.getOrDefault(coin, 0);
    }

    public void reduce(Coin coin) {
        final Integer oldValue = coins.get(coin);
        coins.replace(coin, oldValue, oldValue - 1);
    }

    public void add(Coin coin) {
        final Integer oldValue = coins.get(coin);
        coins.replace(coin, oldValue, oldValue + 1);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "products=" + products +
                ", coins=" + coins +
                '}';
    }
}