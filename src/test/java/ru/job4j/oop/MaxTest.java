package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void whenMax3To4Then4() {
        Max maxNumber = new Max();
        int num1 = 3;
        int num2 = 4;
        int expected = 4;
        int result = maxNumber.max(num1, num2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMax5To7To9Then9() {
        Max maxNumber = new Max();
        int num1 = 5;
        int num2 = 7;
        int num3 = 9;
        int expected = 9;
        int result = maxNumber.max(num1, num2, num3);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMax2To8To6To1Then8() {
        Max maxNumber = new Max();
        int num1 = 2;
        int num2 = 8;
        int num3 = 6;
        int num4 = 1;
        int expected = 8;
        int result = maxNumber.max(num1, num2, num3, num4);
        Assert.assertEquals(expected, result);
    }
}