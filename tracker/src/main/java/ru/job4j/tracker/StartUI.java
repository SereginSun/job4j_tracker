package ru.job4j.tracker;

public class StartUI {
    private static final String LN = System.lineSeparator();

    public static void main(String[] args) {
        Tracker aTracker = new Tracker();
        Item firstItem = new Item("The first item");
        Item secondItem = new Item("The second item");
        Item thirdItem = new Item("The third item");
        Item fourthItem = new Item("The third item");
        aTracker.add(firstItem);
        aTracker.add(secondItem);
        aTracker.add(thirdItem);
        for (var item : aTracker.findAll()) {
            System.out.printf("%s%n", item);
        }
        System.out.print(LN);
        System.out.printf("%s%n", aTracker.findById(2));
        System.out.print(LN);
        aTracker.add(fourthItem);
        for (var item : aTracker.findAll()) {
            System.out.printf("%s%n", item);
        }
        System.out.print(LN);
        for (var item : aTracker.findByName("The third item")) {
            System.out.printf("%s%n", item);
        }
    }
}
