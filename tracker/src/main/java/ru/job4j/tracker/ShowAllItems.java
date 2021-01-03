package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class ShowAllItems implements UserAction {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    @Override
    public String name() {
        return "=== Show all Items.===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allItems = tracker.findAll();
        if (allItems.length == 0) {
            System.out.println("No items");
        }
        for (var item : allItems) {
            System.out.printf("%d%10s%22s%n",
                    item.getId(), item.getName(), FORMATTER.format(item.getCreated()));
        }
        System.out.println();
        return true;
    }
}
