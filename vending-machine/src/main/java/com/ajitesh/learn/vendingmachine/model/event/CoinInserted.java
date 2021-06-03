package com.ajitesh.learn.vendingmachine.model.event;

import com.ajitesh.learn.vendingmachine.model.Coin;
import com.ajitesh.learn.vendingmachine.model.Item;

public class CoinInserted implements Event {

    private final Coin coin;
    private final int transactionId;

    public CoinInserted(Coin coin, int transactionId) {
        this.coin = coin;
        this.transactionId = transactionId;
    }

    @Override
    public Item getItem() {
        return coin;
    }

    @Override
    public int getTransactionId() {
        return transactionId;
    }
}
