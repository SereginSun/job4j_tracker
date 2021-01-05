package ru.job4j.tracker;

public class EditItem implements UserAction {
    private final Output out;

    public EditItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Editing an Item ===");
        int id = input.askInt("Enter the item ID for editing: ");
        String newName = input.askStr("Enter new name of item: ");
        Item editableItem = new Item(newName);
        if (tracker.replace(id, editableItem)) {
            out.println("The item has been successfully edited.");
        } else {
            out.println("No item found with the specified ID.");
        }
        return true;
    }
}
