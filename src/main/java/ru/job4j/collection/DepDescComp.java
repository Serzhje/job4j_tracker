package ru.job4j.collection;

import java.util.Collections;
import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.substring(0, 2).contains(o2.substring(0, 2))) {
           return o1.compareTo(o2);
        } else {
            return o2.compareTo(o1);
        }
    }
}
