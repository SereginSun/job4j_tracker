package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete an Item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Deleting an Item ===");
        int idDel = input.askInt("Enter the item ID for deleting: ");
        if (tracker.delete(idDel)) {
            out.println("The item has been successfully deleted.");
        } else {
            out.println("No item found with the specified ID.");
        }
        return true;
    }
}
