package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public  static int sum(int number) {
        return x + number;
    }

    public int multiply(int number) {
        return x * number;
    }

    public static int minus(int number) {
        return number - x;
    }

    public int divide(int number) {
        return number / x;
    }

    public int sumAllOperation(int number) {
        return sum(number) + multiply(number) + minus(number) + divide(number);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println("Result of an addition operation: " + result);
        Calculator calculator = new Calculator();
        result = calculator.multiply(5);
        System.out.println("Result of the multiplication operation: " + result);
        result = minus(3);
        System.out.println("Result of a subtraction operation: " + result);
        result = calculator.divide(8);
        System.out.println("Result of a division operation: " + result);
        result = calculator.sumAllOperation(20);
        System.out.println("Result of summation all operations: " + result);
    }
}
