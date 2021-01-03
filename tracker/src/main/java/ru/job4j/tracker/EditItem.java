package ru.job4j.tracker;

public class EditItem implements UserAction {
    @Override
    public String name() {
        return "=== Replace an Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter the item ID for editing: ");
        String newName = input.askStr("Enter new name of item: ");
        Item editableItem = new Item(newName);
        if (tracker.replace(id, editableItem)) {
            System.out.println("The item has been successfully edited.");
        } else {
            System.out.println("No item found with the specified ID.");
        }
        return true;
    }
}
