package com.ajitesh.learn.vendingmachine.model;

import com.ajitesh.learn.vendingmachine.model.event.CoinInserted;
import com.ajitesh.learn.vendingmachine.model.event.Event;
import com.ajitesh.learn.vendingmachine.model.event.InStockProductSelected;
import com.ajitesh.learn.vendingmachine.service.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Projection {

    @Autowired
    private EventStore eventStore;
    @Autowired
    TransactionManager transactionManager;

    public Product getProduct() {
        return (Product) eventStore.getEvents().stream()
                .filter(event -> event.getTransactionId() == transactionManager.getId())
                .filter(event -> event instanceof InStockProductSelected).findFirst().get().getItem();
    }

    public int getTotalCoinValue() {
        return eventStore.getEvents().stream()
                .filter(event -> event.getTransactionId() == transactionManager.getId())
                .filter(event -> event instanceof CoinInserted)
                .map(Event::getItem)
                .map(Item::getValue).reduce(0, Integer::sum);
    }
}
