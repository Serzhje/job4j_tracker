package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private static SingleTracker singleTracker = null;
    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }

        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public static void main(String[] args) {
        SingleTracker singleTracker = SingleTracker.getInstance();
        singleTracker.add(new Item("First"));
        singleTracker.add(new Item("Second"));
        singleTracker.add(new Item("Third"));
        System.out.println("findById: ");
        System.out.println(singleTracker.findById(1));
        System.out.println("findAll: ");
        List<Item> arrayItem = singleTracker.findAll();
        for (Item item: arrayItem) {
            System.out.println(item);
        }
        System.out.println("findByName: ");
        arrayItem = singleTracker.findByName("Third");
        for (Item item: arrayItem) {
            System.out.println(item);
        }
        System.out.println("replace: ");
        singleTracker.replace(2, new Item("Test"));
        arrayItem = singleTracker.findAll();
        for (Item item: arrayItem) {
            System.out.println(item);
        }
        System.out.println("delete");
        singleTracker.delete(2);
        arrayItem = singleTracker.findAll();
        for (Item item: arrayItem) {
            System.out.println(item);
        }
    }
}

