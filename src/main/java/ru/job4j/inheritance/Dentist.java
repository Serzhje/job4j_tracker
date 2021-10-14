package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private boolean orthopedist;

    public Dentist(String name, String surname, String education,
                   String birthday, boolean orthopedist) {
        super(name, surname, education, birthday);
        this.orthopedist = orthopedist;
    }

    public void removalOfATooth() {
    }

    public void prosthetics() {
    }
}
