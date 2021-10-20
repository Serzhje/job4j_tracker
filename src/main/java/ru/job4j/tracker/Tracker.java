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

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        int size = 0;
        Item[] itemsTmp = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getName() != null) {
                itemsTmp[size++] = items[i];
            }
        }
        return Arrays.copyOf(itemsTmp, size);
    }

    public Item[] findByName(String key) {
        int size = 0;
        Item[] itemsTmp = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && key.equals(items[i].getName())) {
                itemsTmp[size++] = items[i];
            }
        }
        return Arrays.copyOf(itemsTmp, size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId() == id) {
                rsl = i;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(items[index].getId());
            items[index] = item;
            rsl = true;
        }
        return rsl;
    }
}