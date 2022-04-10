package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка
 * @author Sergey
 * @version 1.0
 */

public class User {
    /**
     * Переменная passport содержит номер паспорта пользователя банка
     * Переменная username содержит данные ФИО пользователя банка
     */
    private String passport;
    private String username;

    /**
     * Конструктор класса User
     * @param passport инициализирует поле passport
     * @param username инициализирует поле username
     */

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * getter
     * @return возвращает текущее значение поля passport
     */

    public String getPassport() {
        return passport;
    }

    /**
     * setter
     * @param passport устанавливает новое значение полю passport
     */

    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * getter
     * @return возвращает текущее значение поля username
     */

    public String getUsername() {
        return username;
    }

    /**
     * setter
     * @param username устанавливает новое значение полю username
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод equals класса Object
     * @param o типа Object, сначала производится проверка на сравнение объекта с самим собой
     * затем проверяем равен ли объект null и сравниваются ли объекты одинаковых классов
     * Если результат двух проверок false, Object приводится к типу User
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
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
        return Objects.hash(passport);
    }
}
