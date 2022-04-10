package ru.job4j.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Класс описывает сервис банка для клиентов и их счетов
 * @author Sergey
 * @version 1.0
 */

public class BankService {
    /**
     * Для хранения данных пользователя банка используется коллекция типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     *Метод addUser() добавляет пользователя в систему:
     * @param user и список для счетов, добавляется в коллекцию users
     * Метод putIfAbsent() добавляет в коллекцию users, если пользователя еще нет в системе
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод addAccount() добавляет новый счет пользователя
     * @param passport используется для поиска пользователя в системе
     * После этого, если пользователь существует, получаем список всех счетов пользователя
     * @param account добавляется, если этого счета нет в списке всех счетов пользователя
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод findByPassport() ищет пользователя по номеру паспорта
     * @param passport используется для поиска пользователя
     * @return возвращает пользователя (user) или null
     */

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод findByRequisite() ищет пользователя по реквизитам
     * @param passport используется для поиска пользователя в системе
     * После этого, если пользователь существует, получаем список всех счетов пользователя
     * @param requisite используется для поиска счета по реквизитам
     * @return возвращает счет(account) или null
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод transferMoney() предназначен для перечисления денег с одного счёта на другой счёт
     * @param srcPassport номер паспорта клиента от которого осуществляется перевод денежных средств
     * @param srcRequisite номер реквизита с которого осуществляется перевод
     * @param destPassport номер паспорта клиента которому переводятся денежные средства
     * @param destRequisite номер реквизита для перечисления денежных средств
     * @param amount количество денежных средств для перевода между счетами
     * @return если счёт найден и хватает денег на счёте srcAccount, то метод возвращает true,
     * Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
     * то метод должен вернуть false.
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        boolean rsl = srcAccount != null && destAccount != null
                && srcAccount.getBalance() >= amount;
        if (rsl) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
        }
        return rsl;
    }
}
