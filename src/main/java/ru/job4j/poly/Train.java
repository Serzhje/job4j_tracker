package ru.job4j.poly;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " moves on rails");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + " speed 80 km/h");
    }
}
