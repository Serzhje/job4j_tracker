package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите вопрос на который можно дать ответ либо да, либо нет");
        String question = in.nextLine();
        System.out.println(question);
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 0:
                System.out.println("Да");
                break;
            case 1:
                System.out.println("Нет");
                break;
            default:
                System.out.println("Может быть");
        }
    }
}
