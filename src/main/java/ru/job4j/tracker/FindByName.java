package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class FindByName implements UserAction {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    private final Output out;

    public FindByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Items by name.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Finding Item by name ===");
        String wantedName = input.ask("Enter the item name for searching: ");
        List<Item> items = tracker.findByName(wantedName);
        if (items.size() > 0) {
            for (var item : items) {
                out.println(item.getId()
                        + ". " + item.getName()
                        + "    " + FORMATTER.format(item.getCreated()));
            }
        } else {
            out.println("No item found with the specified name.");
        }
        out.println("");
        return true;
    }
}
