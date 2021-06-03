package com.ajitesh.learn.vendingmachine.service;

import com.ajitesh.learn.vendingmachine.model.*;
import com.ajitesh.learn.vendingmachine.model.event.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventGenerator {
    Logger logger = LoggerFactory.getLogger(EventGenerator.class);

    @Autowired
    private Inventory inventory;
    @Autowired
    private TransactionManager transactionManager;

    public Event getEventFor(Item item) {
        if (item instanceof Product) {
            Product product = (Product) item;
            transactionManager.createNewTransaction();
            logger.info("Product selected: " + product + ", price: " + product.getValue());
            if (inventory.isProductInStock(product)) {
                return new InStockProductSelected(product, transactionManager.getId());
            } else {
                return new OutOfStockProductSelected(product, transactionManager.getId());
            }
        } else {
            Coin coin = (Coin) item;
            if (coin.equals(Coin.EMPTY)) {
                return new PaymentReceived(coin, transactionManager.getId());
            } else {
                inventory.add(coin);
                logger.info("Coin inserted: " + coin + ", value: " + coin.getValue());
                return new CoinInserted(coin, transactionManager.getId());
            }
        }
    }
}
