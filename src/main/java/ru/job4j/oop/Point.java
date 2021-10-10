package ru.job4j.oop;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {

    private int x;
    private int y;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

    public static void main(String[] args) {
        Point first = new Point(2, 7);
        Point second = new Point(3, 5);
        System.out.println("Point first: x= " + first.x + " y= " + first.y);
        System.out.println("Point second: x= " + second.x + " y= " + second.y);
        double result = first.distance(second);
        System.out.println("расстояние методу точками в системе координат: " + result);
    }
}
