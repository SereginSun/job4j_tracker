package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item newItem = new Item(name);
        tracker.add(newItem);
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ===");
        int id = input.askInt("Enter the item ID for editing: ");
        String newName = input.askStr("Enter new name of item: ");
        Item editableItem = new Item(newName);
        if (tracker.replace(id, editableItem)) {
            System.out.println("The item has been successfully edited.");
        } else {
            System.out.println("No item found with the specified ID.");
        }
    }

    public static void findAll(Tracker tracker) {
        System.out.println("=== Show all Items ===");
        Item[] allItems = tracker.findAll();
        for (var item : allItems) {
            System.out.printf("%d%10s%22s%n",
                    item.getId(), item.getName(), FORMATTER.format(item.getCreated()));
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ===");
        int idDel = input.askInt("Enter the item ID for deleting: ");
        if (tracker.delete(idDel)) {
            System.out.println("The item has been successfully deleted.");
        } else {
            System.out.println("No item found with the specified ID.");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Find Item by ID ===");
        int idWant = input.askInt("Enter the item ID for searching: ");
        Item wantedItem = tracker.findById(idWant);
        if (wantedItem != null) {
            System.out.printf("%d%10s%22s%n",
                    wantedItem.getId(), wantedItem.getName(), FORMATTER.format(wantedItem.getCreated()));
        } else {
            System.out.println("No item found with the specified ID.");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find Items by name ===");
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
    }

    public void init(Input input, Tracker tracker) {

        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(input.askStr("Select menu item: "));
            switch (select) {
                case 0:
                    StartUI.createItem(input, tracker);
                    break;
                case 1:
                    StartUI.findAll(tracker);
                    break;
                case 2:
                    StartUI.replaceItem(input, tracker);
                    break;
                case 3:
                    StartUI.deleteItem(input, tracker);
                    break;
                case 4:
                    StartUI.findById(input, tracker);
                    break;
                case 5:
                    StartUI.findByName(input, tracker);
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + select);
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all Items.");
        System.out.println("2. Edit Item.");
        System.out.println("3. Delete Item.");
        System.out.println("4. Find Item by ID.");
        System.out.println("5. Find Items by name.");
        System.out.println("6. Exit program.");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
