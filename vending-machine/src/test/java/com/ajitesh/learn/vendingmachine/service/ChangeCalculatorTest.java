package com.ajitesh.learn.vendingmachine.service;

import com.ajitesh.learn.vendingmachine.model.Coin;
import com.ajitesh.learn.vendingmachine.model.Inventory;
import com.ajitesh.learn.vendingmachine.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChangeCalculatorTest {

    @Autowired
    private ChangeCalculator changeCalculator;

    @Test
    public void testForMaxValue() {
//        List<Coin> expectedOutput = List.of(Coin.QUARTER, Coin.QUARTER, Coin.DIME, Coin.NICKEL, Coin.PENNY, Coin.PENNY);
        List<Coin> expectedOutput = List.of(Coin.QUARTER, Coin.DIME, Coin.DIME, Coin.DIME, Coin.DIME, Coin.PENNY, Coin.PENNY);
        changeCalculator.processChangeReturn(67);
        assert changeCalculator.getCoins().equals(expectedOutput);
    }

    @Test
    public void testForFourPennies() {
        List<Coin> expectedOutput = List.of(Coin.PENNY, Coin.PENNY, Coin.PENNY, Coin.PENNY);
        changeCalculator.processChangeReturn(4);
        assert changeCalculator.getCoins().equals(expectedOutput);
    }

    @Test
    public void testForOneNickel() {
        List<Coin> expectedOutput = List.of(Coin.NICKEL);
        changeCalculator.processChangeReturn(5);
        assert changeCalculator.getCoins().equals(expectedOutput);
    }

    @Test
    public void testForOnePenny() {
        List<Coin> expectedOutput = List.of(Coin.PENNY);
        changeCalculator.processChangeReturn(1);
        assert changeCalculator.getCoins().equals(expectedOutput);
    }

    @Test
    public void testForNoChange() {
        List<Coin> expectedOutput = List.of();
        changeCalculator.processChangeReturn(0);
        assert changeCalculator.getCoins().equals(expectedOutput);
    }

}