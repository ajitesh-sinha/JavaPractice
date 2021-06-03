package com.ajitesh.learn.vendingmachine.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductCodeMap {

    private final Map<ProductCode, Product> productCodeMap;

    public ProductCodeMap(List<ProductCode> productCodes, List<Product> products) {
        if (products.size() > productCodes.size()) {
            throw new RuntimeException("There are not enough slots to accommodate all the products.");
        }
        productCodeMap = IntStream.range(0, products.size()).boxed().collect(Collectors.toMap(productCodes::get, products::get));
        System.out.println("Vending machine stocked: " + productCodeMap);
    }

    public Map<ProductCode, Product> get() {
        return productCodeMap;
    }
}
