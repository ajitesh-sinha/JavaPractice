package com.ajitesh.learn.vendingmachine.model;

import com.ajitesh.learn.vendingmachine.model.state.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VendingMachine {
    Logger logger = LoggerFactory.getLogger(VendingMachine.class);
    private State state;

    public VendingMachine(State state) {
        this.state = state;
        logger.info(this.state.getMessage().getText());
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        logger.info(state.getMessage().getText());
    }
}
