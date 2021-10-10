package ru.job4j.oop;

public class Max {

    public int max(int num1, int num2) {
        return num1 >= num2 ? num1 : num2;
    }

    public int max(int num1, int num2, int num3) {
       return max(max(num1, num2), num3);
    }

    public int max(int num1, int num2, int num3, int num4) {
        return max(max(num1, num2), max(num3, num4));
    }
}
