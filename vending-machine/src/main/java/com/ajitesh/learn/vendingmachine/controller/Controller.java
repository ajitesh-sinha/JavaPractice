package com.ajitesh.learn.vendingmachine.controller;

import com.ajitesh.learn.vendingmachine.model.Coin;
import com.ajitesh.learn.vendingmachine.model.ProductCode;
import com.ajitesh.learn.vendingmachine.model.ProductCodeMap;
import com.ajitesh.learn.vendingmachine.model.VendingMachine;
import com.ajitesh.learn.vendingmachine.model.event.Event;
import com.ajitesh.learn.vendingmachine.model.state.WaitingForCoin;
import com.ajitesh.learn.vendingmachine.model.state.WaitingForNewTransaction;
import com.ajitesh.learn.vendingmachine.service.EventGenerator;
import com.ajitesh.learn.vendingmachine.service.EventProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private VendingMachine vendingMachine;
    @Autowired
    private EventGenerator eventGenerator;
    @Autowired
    EventProcessor eventProcessor;
    @Autowired
    private ProductCodeMap productCodeMap;

    @PostMapping(value = "/selectProduct")
    public void selectProduct(@RequestBody ProductCode productCode) throws Exception {
        if (vendingMachine.getState() instanceof WaitingForNewTransaction) {
            Event event = eventGenerator.getEventFor(productCodeMap.get().get(productCode));
            eventProcessor.process(event);
        } else {
            throw new Exception("Cannot select product when system state is: <" + vendingMachine.getState().getMessage().getText() + ">");
        }
    }

    @PostMapping(value = "/insertCoin")
    public void insertCoin(@RequestBody Coin coin) throws Exception {
        if (vendingMachine.getState() instanceof WaitingForCoin) {
            if (coin.equals(Coin.EMPTY)) {
                throw new Exception("Invalid Coin entered.");
            }
            Event event = eventGenerator.getEventFor(coin);
            eventProcessor.process(event);
        } else {
            throw new Exception("Cannot enter coin when system state is: <" + vendingMachine.getState().getMessage().getText() + ">");
        }
    }
}
