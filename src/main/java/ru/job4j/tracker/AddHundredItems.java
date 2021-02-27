package ru.job4j.tracker;

public class AddHundredItems implements UserAction {
    private final Output out;

    public AddHundredItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create hundred items.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Create a hundred new Items ===");
        int number = Integer.parseInt(input.ask("How much to create?"));
        for (int i = 1; i <= number; i++) {
            tracker.add(new Item("Item" + i));
        }
        out.println("");
        return true;
    }
}
