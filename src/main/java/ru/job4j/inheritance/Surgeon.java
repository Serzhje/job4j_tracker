package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private boolean plasticSurgeon;

    public Surgeon(String name, String surname, String education,
                   String birthday, boolean plastic) {
        super(name, surname, education, birthday);
        this.plasticSurgeon = plastic;
    }

    public void plasticSurgery() {
    }

    public void neurosurgeon() {
    }
}
