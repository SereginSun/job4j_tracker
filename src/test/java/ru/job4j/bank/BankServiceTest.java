package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("1234 5678", "Vasia");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("1234 5678"), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("1234 5678", "Vasia");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5432", 150D));
        assertNull(bank.findByRequisite("1234", "5432"));
    }

    @Test
    public void addAccount() {
        User user = new User("1234 5678", "Vasia");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5432", 150D));
        assertNull(bank.findByRequisite("1234", "5432"));
    }

    @Test
    public void transferMoney() {
        User user = new User("1234 5678", "Vasia");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5432", 150D));
        bank.addAccount(user.getPassport(), new Account("1234", 50D));
        bank.transferMoney(user.getPassport(), "5432", user.getPassport(), "1234", 150);
        assertThat(bank.findByRequisite(user.getPassport(), "1234").getBalance(), is(200D));
    }
}