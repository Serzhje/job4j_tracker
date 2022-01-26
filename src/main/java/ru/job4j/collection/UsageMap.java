package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> infoPerson = new HashMap<>();
        infoPerson.put("ivan@mail.ru", "Ivanov Ivan Ivanovich");
        infoPerson.put("sergey@yandex.ru", "Titov Sergey Sergeevich");
        infoPerson.put("vladimir@gmail.com", "Petrov Vladimir Dmitrievich");

        for (String key : infoPerson.keySet()) {
            String value = infoPerson.get(key);
                System.out.println(key + " = " + value);
        }
    }
}
