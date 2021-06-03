package com.ajitesh.learn.vendingmachine.model.event;

import com.ajitesh.learn.vendingmachine.model.Product;

public abstract class ProductSelected implements Event {
    protected Product product;
    protected int transactionId;
}
