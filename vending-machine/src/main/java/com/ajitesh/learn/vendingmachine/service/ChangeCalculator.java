package com.ajitesh.learn.vendingmachine.service;

import com.ajitesh.learn.vendingmachine.model.Coin;
import com.ajitesh.learn.vendingmachine.model.Inventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChangeCalculator {
    Logger logger = LoggerFactory.getLogger(ChangeCalculator.class);

    @Autowired
    private Inventory inventory;

    private final List<Coin> coins;

    public ChangeCalculator() {
        coins = new ArrayList<>();
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void processChangeReturn(int change) {
        coins.clear();
        if (change > 0) {
            change = calculateCoinsAndGetRemainingChange(change, Coin.QUARTER);
            if (change != 0)
                change = calculateCoinsAndGetRemainingChange(change, Coin.DIME);
            if (change != 0)
                change = calculateCoinsAndGetRemainingChange(change, Coin.NICKEL);
            if (change != 0)
                change = calculateCoinsAndGetRemainingChange(change, Coin.PENNY);
            if (change != 0)
                logger.error("Coins not available for change, returning coins inserted");
            logger.info("Please collect change: " + coins);
        } else {
            logger.info("Change not applicable");
        }
    }

    private int calculateCoinsAndGetRemainingChange(int change, Coin coin) {
        int requiredCoinCount, loopCounter;
        if ((requiredCoinCount = change / coin.getValue()) != 0) {
            int inventoryCount = inventory.getCountOf(coin);
            loopCounter = Math.min(requiredCoinCount, inventoryCount);

            while (loopCounter != 0) {
                coins.add(coin);
                inventory.reduce(coin);
                loopCounter--;
            }
            int val = change % coin.getValue();
            if (requiredCoinCount > inventoryCount) {
                int diffValue = (requiredCoinCount - inventoryCount) * coin.getValue();
                return val == 0 ? diffValue : (val + diffValue);
            }
            return val;
        }
        return change;
    }
}
