package com.ajitesh.learn.vendingmachine.service;

import com.ajitesh.learn.vendingmachine.model.Inventory;
import com.ajitesh.learn.vendingmachine.model.Product;
import com.ajitesh.learn.vendingmachine.model.Projection;
import com.ajitesh.learn.vendingmachine.model.VendingMachine;
import com.ajitesh.learn.vendingmachine.model.event.Event;
import com.ajitesh.learn.vendingmachine.model.event.PaymentReceived;
import com.ajitesh.learn.vendingmachine.model.state.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CloseTransaction {
    Logger logger = LoggerFactory.getLogger(CloseTransaction.class);

    @Autowired
    Inventory inventory;
    @Autowired
    VendingMachine vendingMachine;
    @Autowired
    State waitingForNewTransaction;
    @Autowired
    private Projection projection;
    @Autowired
    private ChangeCalculator changeCalculator;


    public void execute(Event event) {
        if (event instanceof PaymentReceived) {
            processVending();
        }
        changeCalculator.processChangeReturn(projection.getTotalCoinValue() - projection.getProduct().getValue());
        vendingMachine.setState(waitingForNewTransaction);
        logger.info(inventory.toString());
    }

    private void processVending() {
        Product product = projection.getProduct();
        logger.info("Vending product: " + product.name());
        inventory.updateStock(product);
    }


}
