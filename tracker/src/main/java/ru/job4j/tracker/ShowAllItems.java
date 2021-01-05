package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class ShowAllItems implements UserAction {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    private final Output out;

    public ShowAllItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all Items.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all Items.===");
        Item[] allItems = tracker.findAll();
        if (allItems.length == 0) {
            out.println("No items");
        }
        for (var item : allItems) {
            out.println(item.getId() + ". " + item.getName() + "    " + FORMATTER.format(item.getCreated()));
        }
        out.println("");
        return true;
    }
}
