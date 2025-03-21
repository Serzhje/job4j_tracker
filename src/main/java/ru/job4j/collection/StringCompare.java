package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int len = Integer.compare(left.length(), right.length());
        for (int i = 0; i < left.length() && i < right.length(); i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                break;
            }
        }
        return  rsl == 0 && len != 0 ? len : rsl;
    }
}
