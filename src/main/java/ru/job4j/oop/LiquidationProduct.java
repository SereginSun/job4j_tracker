package ru.job4j.oop;

public class LiquidationProduct {
    private final Product product;

    public LiquidationProduct(String name, int price) {
        product = new Product(name, price);
    }

    public Product getProduct() {
        return product;
    }
}
