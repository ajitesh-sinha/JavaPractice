package com.ajitesh.learn.vendingmachine.service;

import com.ajitesh.learn.vendingmachine.model.Coin;
import com.ajitesh.learn.vendingmachine.model.Inventory;
import com.ajitesh.learn.vendingmachine.model.Product;
import org.junit.Test;

import java.util.EnumMap;

public class InventoryTest {
    @Test
    public void testInventory() {
        var coins = new EnumMap<Coin, Integer>(Coin.class);
        coins.put(Coin.DIME, 20);
        coins.put(Coin.NICKEL, 10);
        var products = new EnumMap<Product, Integer>(Product.class);
        products.put(Product.DietCoke, 5);
        products.put(Product.MountainDew, 4);
        var inventory = new Inventory(products, coins);
        assert (inventory.getProducts().size() == 2);
    }
}
