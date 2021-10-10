package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when458To595Then5dot10() {
        Point first = new Point(4, 5, 8);
        Point second = new Point(5, 9, 5);
        double result = first.distance3d(second);
        double expected = 5.10;
        Assert.assertEquals(expected, result, 0.01);
    }

    @Test
    public void when149To158Then1dot41() {
        Point first = new Point(1, 4, 9);
        Point second = new Point(1, 5, 8);
        double result = first.distance3d(second);
        double expected = 1.41;
        Assert.assertEquals(expected, result, 0.01);
    }
}