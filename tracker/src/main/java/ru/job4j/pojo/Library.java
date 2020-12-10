package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book firstBook = new Book("Core Java", 928);
        Book secondBook = new Book("Clean code", 464);
        Book thirdBook = new Book("Effective Java", 310);
        Book[] books = new Book[3];
        books[0] = firstBook;
        books[1] = secondBook;
        books[2] = thirdBook;
        for (Book aBook : books) {
            System.out.printf("%-14s - %d%n", aBook.getName(), aBook.getAmountOfPages());
        }
        System.out.printf("%nReplace firstBook with thirdBook:%n");
        books[0] = thirdBook;
        books[2] = firstBook;
        for (Book aBook : books) {
            System.out.printf("%-14s - %d%n", aBook.getName(), aBook.getAmountOfPages());
        }
        System.out.printf("%n");
        for (Book aBook : books) {
            if (aBook.getName().equals("Clean code")) {
                System.out.printf("%-14s - %d%n", aBook.getName(), aBook.getAmountOfPages());
            }
        }
    }
}
