package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета, класс содержит поля: баланс и реквизиты
 * @author Sergey
 * @version 1.0
 */

public class Account {
    /**
     * Переменная requisite содержит информацию по реквизитам
     * Переменная balance содержит количество денежных средств
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор класса Account
     * @param requisite инициализирует поле requisite
     * @param balance инициализирует поле balance
     */

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * getter
     * @return возвращает текущее значение поля requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * setter
     * @param requisite устанавливает новое значение полю requisite
     */

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * getter
     * @return возвращает текущее значение поля balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * setter
     * @param balance устанавливает новое значение полю balance
     */

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод equals класса Object
     * @param o типа Object, сначала производится проверка на сравнение объекта с самим собой
     * затем проверяем равен ли объект null и сравниваются ли объекты одинаковых классов
     * Если результат двух проверок false, Object приводится к типу Account
     * и выполняется сравнение полей объектов
     * @return результат сравнения true или false
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод hashCode класса Object.
     * Используется для сравнения объектов, выполняется быстрее, чем equals.
     * Вызывается первым, если hashcode разный, то два объекта точно разные.
     * Если два объекта равны, вызывается метод equals()
     * @return  возвращает 32-битное значение типа int
     */

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
