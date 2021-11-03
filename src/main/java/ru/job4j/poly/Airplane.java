package ru.job4j.poly;

public class Airplane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " fly");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + " speed 700 km/h");
    }

}
