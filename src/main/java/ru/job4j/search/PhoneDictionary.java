package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        var predName = (Predicate<Person>) p -> p.getName().contains(key);
        var predSurname = (Predicate<Person>) p -> p.getSurname().contains(key);
        var predPhone = (Predicate<Person>) p -> p.getPhone().contains(key);
        var predAddress = (Predicate<Person>) p -> p.getAddress().contains(key);
        var combine = predName.or(predSurname).or(predPhone).or(predAddress);

        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
