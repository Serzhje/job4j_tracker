package ru.job4j.poly;

public class Bus implements Transport {

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
}
