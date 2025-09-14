package ru.job4j.search;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk"));
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenNotFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(
                new Person("Dmitry", "Ivanov", "897123", "Moscow"));
        var persons = phones.find("St.Petersburg");
        assertEquals(persons.size(), 0);
    }
}