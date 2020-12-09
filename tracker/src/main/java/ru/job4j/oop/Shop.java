package ru.job4j.oop;

public class Shop {
    public static void main(String[] args) {
        Product firstProduct = of("Oil", 100);
        System.out.println(firstProduct.label());
    }

    public static Product of(String name, int price) {
        return new LiquidationProduct(name, price).getProduct();
    }
}
