package ru.job4j.ex;

public class FindMaxLength {
    public static void main(String[] args) {
        String[] shop = {"Ebay", null, "Amazon", null, "Ozon"};
        int max = 0;
        for (int i = 0; i < shop.length; i++) {
            String el = shop[i];
            if (el != null && el.length() > max) {
                max = el.length();
            }
        }
        System.out.println("Max length: " + max);
    }
}
