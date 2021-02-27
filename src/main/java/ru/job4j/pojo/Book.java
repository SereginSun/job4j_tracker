package ru.job4j.pojo;

public class Book {
    private final String name;
    private final int amountOfPages;

    public Book(String name, int amountOfPages) {
        this.name = name;
        this.amountOfPages = amountOfPages;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }
}
