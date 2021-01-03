package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class FindByName implements UserAction {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    @Override
    public String name() {
        return "=== Find Items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String wantedName = input.askStr("Enter the item name for searching: ");
        Item[] items = tracker.findByName(wantedName);
        if (items.length > 0) {
            for (var item : items) {
                System.out.printf("%d%10s%22s%n",
                        item.getId(), item.getName(), FORMATTER.format(item.getCreated()));
            }
        } else {
            System.out.println("No item found with the specified name.");
        }
        return true;
    }
}
