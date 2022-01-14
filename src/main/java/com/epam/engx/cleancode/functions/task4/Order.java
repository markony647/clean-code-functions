package com.epam.engx.cleancode.functions.task4;

import com.epam.engx.cleancode.functions.task4.thirdpartyjar.Product;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Order {

    private List<Product> products;

    public Double getPriceOfAvailableProducts() {
        List<Product> availableProducts = getAvailableProducts();
        return countPrice(availableProducts);
    }

    private double countPrice(List<Product> products) {
        return products.stream()
                .map(Product::getProductPrice)
                .reduce(0.0, Double::sum);
    }

    private List<Product> getAvailableProducts() {
        return products.stream()
                .filter(Product::isAvailable)
                .collect(toList());
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
