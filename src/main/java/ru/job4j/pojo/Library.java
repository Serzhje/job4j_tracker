package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book java = new Book("philosophy java", 1168);
        Book code = new Book("Clean code", 500);
        Book history = new Book("The History Book", 440);
        Book math = new Book("The Maths Book", 350);
        Book[] arrayBook = new Book[4];
        arrayBook[0] = java;
        arrayBook[1] = code;
        arrayBook[2] = history;
        arrayBook[3] = math;
        for (int i = 0; i < arrayBook.length; i++) {
            System.out.println(arrayBook[i].getName() + ": " + arrayBook[i].getCountSheets());
        }
        System.out.println();
        Book tmp = arrayBook[0];
        arrayBook[0] = arrayBook[3];
        arrayBook[3] = tmp;
        for (int i = 0; i < arrayBook.length; i++) {
            System.out.println(arrayBook[i].getName() + ": " + arrayBook[i].getCountSheets());
        }
        System.out.println();
        for (int i = 0; i < arrayBook.length; i++) {
            if ("Clean code".equals(arrayBook[i].getName())) {
                System.out.println(arrayBook[i].getName() + ": " + arrayBook[i].getCountSheets());
            }
        }
    }
}
