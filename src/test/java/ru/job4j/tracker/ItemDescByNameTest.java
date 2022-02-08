package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemDescByNameTest {
    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "First"),
                new Item(2, "Second"),
                new Item(3, "Third"),
                new Item(4, "Fourth"),
                new Item(5, "Fifth")
        );

        Collections.sort(items, new ItemDescByName());

        List<Item> expected = Arrays.asList(
                new Item(3, "Third"),
                new Item(2, "Second"),
                new Item(4, "Fourth"),
                new Item(1, "First"),
                new Item(5, "Fifth")
        );
        assertEquals(expected, items);
    }
}