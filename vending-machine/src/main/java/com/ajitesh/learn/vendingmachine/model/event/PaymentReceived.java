package com.ajitesh.learn.vendingmachine.model.event;

import com.ajitesh.learn.vendingmachine.model.Coin;

public class PaymentReceived extends CoinInserted {
    public PaymentReceived(Coin coin, int transactionId) {
        super(coin, transactionId);
    }
}
