package com.ajitesh.learn.vendingmachine.model;

import org.springframework.stereotype.Component;

@Component
public class TransactionManager {

    private int transactionId = 1000;

    public int getId() {
        return transactionId;
    }

    public void createNewTransaction() {
        transactionId++;
    }
}
