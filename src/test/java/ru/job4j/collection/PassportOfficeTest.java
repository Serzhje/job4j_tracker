package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {
    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenDuplicateKey() {
        Citizen citizenTitov = new Citizen("2235 3256", "Fedor Titov");
        Citizen citizenPetrov = new Citizen("2235 3256", "Sergey Petrov");
        PassportOffice office = new PassportOffice();
        office.add(citizenTitov);
        assertFalse(office.add(citizenPetrov));
    }
}