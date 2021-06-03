package com.ajitesh.learn.vendingmachine.model.event;

import com.ajitesh.learn.vendingmachine.model.Item;

public interface Event {
    Item getItem();
    int getTransactionId();
}
