package ru.job4j.pojo;

import java.util.Date;

public class Police {
    public static void main(String[] args) {
        License license = new License();
        license.setCode("xx111x");
        license.setCreated(new Date());
        license.setModel("Toyota");
        license.setOwner("Petr Arsentev");

        System.out.println(license.getOwner() + " has a car - " + license.getModel()
                + " : " + license.getCode());
    }
}
