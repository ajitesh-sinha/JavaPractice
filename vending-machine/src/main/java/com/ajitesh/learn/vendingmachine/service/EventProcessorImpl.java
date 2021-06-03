package com.ajitesh.learn.vendingmachine.service;

import com.ajitesh.learn.vendingmachine.model.Coin;
import com.ajitesh.learn.vendingmachine.model.Projection;
import com.ajitesh.learn.vendingmachine.model.VendingMachine;
import com.ajitesh.learn.vendingmachine.model.event.*;
import com.ajitesh.learn.vendingmachine.model.state.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventProcessorImpl implements EventProcessor{

    Logger logger = LoggerFactory.getLogger(EventProcessorImpl.class);

    @Autowired
    private EventStore eventStore;
    @Autowired
    private Projection projection;
    @Autowired
    private VendingMachine vendingMachine;
    @Autowired
    private State productOutOfStock;
    @Autowired
    private State waitingForCoin;
    @Autowired
    private State transactionComplete;
    @Autowired
    private CloseTransaction closeTransaction;
    @Autowired
    private EventGenerator eventGenerator;

    @Override
    public void process(Event event) {
        eventStore.create(event);
        if (event instanceof OutOfStockProductSelected) {
            vendingMachine.setState(productOutOfStock);
        } else if (event instanceof InStockProductSelected) {
            vendingMachine.setState(waitingForCoin);
        } else if (event instanceof CoinInserted) {
            final int totalCoinValue = projection.getTotalCoinValue();
            final int productCost = projection.getProduct().getValue();
            if (totalCoinValue >= productCost) {
                vendingMachine.setState(transactionComplete);
                Event newEvent = eventGenerator.getEventFor(Coin.EMPTY);
                eventStore.create(newEvent);
                closeTransaction.execute(newEvent);
            } else {
                logger.info("Waiting for coins for remaining value: " + (productCost - totalCoinValue));
                vendingMachine.setState(waitingForCoin);
            }
        }
    }
}
