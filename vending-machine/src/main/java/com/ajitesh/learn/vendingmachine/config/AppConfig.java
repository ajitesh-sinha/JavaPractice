package com.ajitesh.learn.vendingmachine.config;

import com.ajitesh.learn.vendingmachine.model.*;
import com.ajitesh.learn.vendingmachine.model.state.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.EnumMap;

@Configuration
public class AppConfig {

    @Bean
    public ProductCodeMap productCodeMap() {
        return new ProductCodeMap(Arrays.asList(ProductCode.values()), Arrays.asList(Product.values()));
    }

    @Bean
    public Inventory inventory() {
        var products = new EnumMap<Product, Integer>(Product.class);
        var coins = new EnumMap<Coin, Integer>(Coin.class);
        Arrays.stream(Product.values()).forEach(product -> products.put(product, 5));
        Arrays.stream(Coin.values()).forEach(coin -> coins.put(coin, 20));
        coins.put(Coin.QUARTER, 1);
        return new Inventory(products, coins);
    }

    @Bean
    public State waitingForNewTransaction() {
        return new WaitingForNewTransaction(new Message("Select Product"));
    }

    @Bean
    public VendingMachine vendingMachine(State waitingForNewTransaction) {
        return new VendingMachine(waitingForNewTransaction);
    }

    @Bean
    public State waitingForCoin() {
        return new WaitingForCoin(new Message("Insert coin"));
    }

    @Bean
    public State productOutOfStock() {
        return new ProductOutOfStock(new Message("Selected product is out of stock!"));
    }

    @Bean
    public State transactionComplete() {
        return new TransactionComplete(new Message("Total payment received."));
    }

    @Bean
    public State transactionAborted() {
        return new TransactionAborted(new Message("Transaction aborted, please collect change!"));
    }
}
