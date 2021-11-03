package ru.job4j.poly;

public class Bus implements Transport, Vehicle {

    @Override
    public void drive() {
        System.out.println("Drive");
    }

    @Override
    public void passengers(int amountPassenger) {
        System.out.println("Число пассажиров " + amountPassenger);
    }

    @Override
    public double refuel(double amountFuel) {
        double fuelCost = 50.0;
        return amountFuel * fuelCost;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " moves on highways");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + " speed 110 km/h");
    }

}
