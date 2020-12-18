package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNulls = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null) {
                itemsWithoutNulls[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemsWithoutNulls, size);
    }

    public Item[] findByName(String key) {
        Item[] itemsWithMatchedKey = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                itemsWithMatchedKey[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemsWithMatchedKey, size);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                result = i;
                break;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            result = true;
         }
        return result;
    }
}
