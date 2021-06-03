package com.ajitesh.learn.vendingmachine.model.event;

import com.ajitesh.learn.vendingmachine.model.Item;
import com.ajitesh.learn.vendingmachine.model.Product;

public class InStockProductSelected extends ProductSelected {

    public InStockProductSelected(Product product, int transactionId) {
        this.product = product;
        this.transactionId = transactionId;
    }

    @Override
    public Item getItem() {
        return product;
    }

    @Override
    public int getTransactionId() {
        return transactionId;
    }
}
