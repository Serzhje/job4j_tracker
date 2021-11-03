package ru.job4j.poly;

public class VehicleTest {

    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle[] vehicles = new Vehicle[] {bus, airplane, train};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.speed();
            System.out.println();
        }
    }
}
