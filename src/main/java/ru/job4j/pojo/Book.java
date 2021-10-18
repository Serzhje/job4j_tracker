package ru.job4j.pojo;

public class Book {

    private String name;
    private int countSheets;

    public Book(String name, int countSheets) {
        this.name = name;
        this.countSheets = countSheets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountSheets() {
        return countSheets;
    }

    public void setCountSheets(int countSheets) {
        this.countSheets = countSheets;
    }
}
