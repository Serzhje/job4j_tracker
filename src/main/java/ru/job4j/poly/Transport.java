package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers(int amountPassenger);

    int refuel(int amountFuel);
}
