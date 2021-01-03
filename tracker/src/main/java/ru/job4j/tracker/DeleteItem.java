package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idDel = input.askInt("Enter the item ID for deleting: ");
        if (tracker.delete(idDel)) {
            System.out.println("The item has been successfully deleted.");
        } else {
            System.out.println("No item found with the specified ID.");
        }
        return true;
    }
}
