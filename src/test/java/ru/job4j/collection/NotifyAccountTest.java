package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {
    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expected = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expected));
    }

    @Test
    public void whenRemovingDuplicates() {
        List<Account> accounts = Arrays.asList(
                new Account("1557", "Ivan Ivanov", "3287652"),
                new Account("7346", "Dmitriy Petrov", "e489356"),
                new Account("1557", "Ivan Ivanov", "d34325"),
                new Account("678", "Fedor Titov", "df21566436"),
                new Account("7346", "Dmitriy Petrov", "4546j")
        );
        HashSet<Account> expected = new HashSet<>(
                Arrays.asList(
                        new Account("1557", "Ivan Ivanov", "3287652"),
                        new Account("7346", "Dmitriy Petrov", "e489356"),
                        new Account("678", "Fedor Titov", "df21566436")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expected));
    }
}