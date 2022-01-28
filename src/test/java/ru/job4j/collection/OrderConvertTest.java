package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenManyOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("124334", "First"));
        orders.add(new Order("32542", "Second"));
        orders.add(new Order("124334", "Third"));
        orders.add(new Order("gh435", "Fourth"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("124334"), is(new Order("124334", "Third")));
    }
}