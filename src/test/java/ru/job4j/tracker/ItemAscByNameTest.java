package ru.job4j.tracker;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemAscByNameTest {
    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "First"),
                new Item(2, "Second"),
                new Item(3, "Third"),
                new Item(4, "Fourth"),
                new Item(5, "Fifth")
        );

        Collections.sort(items, new ItemAscByName());

        List<Item> expected = Arrays.asList(
                new Item(5, "Fifth"),
                new Item(1, "First"),
                new Item(4, "Fourth"),
                new Item(2, "Second"),
                new Item(3, "Third")
        );
        assertEquals(expected, items);
    }
}