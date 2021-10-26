package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches > 3 || matches < 1 || matches > count) {
                if (matches > count) {
                    System.out.println("Введите количество спичек не больше " + count);
                } else {
                    System.out.println("Вы ввели неверное количество спичек "
                            + System.lineSeparator() + "Повторите ввод");
                }
                continue;
            }
            turn = !turn;
            count = count - matches;
            System.out.println("Спичек осталось на столе " + count);
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
