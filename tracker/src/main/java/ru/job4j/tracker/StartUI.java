package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0:
                    System.out.println("=== Create a new Item ===");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item newItem = new Item(name);
                    tracker.add(newItem);
                    break;
                case 1:
                    System.out.println("=== Show all Items ===");
                    Item[] allItems = tracker.findAll();
                    for (var item : allItems) {
                        System.out.printf("%d%10s%22s%n",
                                item.getId(), item.getName(), formatter.format(item.getCreated()));
                    }
                    break;
                case 2:
                    System.out.println("=== Edit Item ===");
                    System.out.println("Enter the item ID for editing: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new name of item: ");
                    String newName = scanner.nextLine();
                    Item editableItem = new Item(newName);
                    if (tracker.replace(id, editableItem)) {
                        System.out.println("The item has been successfully edited.");
                    } else {
                        System.out.println("No item found with the specified ID.");
                    }
                    break;
                case 3:
                    System.out.println("=== Delete Item ===");
                    System.out.println("Enter the item ID for deleting: ");
                    int idDel = Integer.parseInt(scanner.nextLine());
                    if (tracker.delete(idDel)) {
                        System.out.println("The item has been successfully deleted.");
                    } else {
                        System.out.println("No item found with the specified ID.");
                    }
                    break;
                case 4:
                    System.out.println("=== Find Item by ID ===");
                    System.out.println("Enter the item ID for searching: ");
                    int idWant = Integer.parseInt(scanner.nextLine());
                    Item wantedItem = tracker.findById(idWant);
                    if (wantedItem != null) {
                        System.out.printf("%d%10s%22s%n",
                                wantedItem.getId(), wantedItem.getName(), formatter.format(wantedItem.getCreated()));
                    } else {
                        System.out.println("No item found with the specified ID.");
                    }
                    break;
                case 5:
                    System.out.println("=== Find Items by name ===");
                    System.out.println("Enter the item name for searching: ");
                    String wantedName = scanner.nextLine();
                    Item[] items = tracker.findByName(wantedName);
                    if (items.length > 0) {
                        for (var item : items) {
                            System.out.printf("%d%10s%22s%n",
                                    item.getId(), item.getName(), formatter.format(item.getCreated()));
                        }
                    } else {
                        System.out.println("No item found with the specified name.");
                    }
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
