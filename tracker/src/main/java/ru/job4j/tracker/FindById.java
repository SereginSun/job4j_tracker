package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class FindById implements UserAction {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    private final Output out;

    public FindById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by ID.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Finding Item by ID ===");
        int idWant = input.askInt("Enter the item ID for searching: ");
        Item wantedItem = tracker.findById(idWant);
        if (wantedItem != null) {
            out.println(wantedItem.getId()
                            + ". " + wantedItem.getName()
                            + "    " + FORMATTER.format(wantedItem.getCreated())
            );
            out.println("");
        } else {
            out.println("No item found with the specified ID.");
        }
        return true;
    }
}
