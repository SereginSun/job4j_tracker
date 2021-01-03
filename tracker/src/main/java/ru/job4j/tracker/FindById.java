package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class FindById implements UserAction {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    @Override
    public String name() {
        return "=== Find Item by ID ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idWant = input.askInt("Enter the item ID for searching: ");
        Item wantedItem = tracker.findById(idWant);
        if (wantedItem != null) {
            System.out.printf("%d%10s%22s%n",
                    wantedItem.getId(), wantedItem.getName(), FORMATTER.format(wantedItem.getCreated()));
            System.out.println();
        } else {
            System.out.println("No item found with the specified ID.");
        }
        return true;
    }
}
