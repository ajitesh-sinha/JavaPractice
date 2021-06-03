package com.ajitesh.learn.vendingmachine.service;

import com.ajitesh.learn.vendingmachine.model.Product;
import com.ajitesh.learn.vendingmachine.model.ProductCodeMap;
import com.ajitesh.learn.vendingmachine.model.ProductCode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class ProductCodeMapTest {

    @Test
    public void productCodeInitializeTest() {
        var productCodeMapProvider = new ProductCodeMap(Arrays.asList(ProductCode.A1, ProductCode.A2), Arrays.asList(Product.MountainDew, Product.DietCoke));
        final Map<ProductCode, Product> productCodeMap = productCodeMapProvider.get();
        System.out.println(productCodeMap);
        assert productCodeMap.size() == 2;
    }

    @Test (expected = RuntimeException.class)
    public void productCodeInitializeExceptionTest() {
        var productCodeMapProvider = new ProductCodeMap(Arrays.asList(ProductCode.A1, ProductCode.A2), Arrays.asList(Product.MountainDew, Product.DietCoke, Product.Pepsi));
        final Map<ProductCode, Product> productCodeMap = productCodeMapProvider.get();
        System.out.println(productCodeMap);
        assert productCodeMap.size() == 2;
    }
}
