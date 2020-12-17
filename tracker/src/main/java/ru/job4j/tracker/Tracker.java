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
        Item result = null;
        for (int index = 0; index < size; index++) {
            Item someItem = items[index];
            if (someItem.getId() == id) {
                result = someItem;
                break;
            }
        }
        return result;
    }
}
