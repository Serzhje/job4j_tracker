package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Ivan Ivanovich");
        student.setGroup((short) 743);
        Date date = new Date(2021, 9, 1);
        student.setDate(date);
        System.out.println("ФИО: " + student.getFullName() + ", группа: " + student.getGroup()
                + ", дата поступления: "
                + student.getDate().getYear() + " " + student.getDate().getMonth()
                + " " + student.getDate().getDate());
    }
}
