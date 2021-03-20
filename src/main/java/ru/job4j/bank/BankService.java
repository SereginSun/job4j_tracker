package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The class describes the banking system model.
 * @author Seregin Vladimir
 * @version 1.0
 */
public class BankService {

    /**
     * The field containing all users with associated accounts.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * The method adds a user to the banking system after checking if he is in the system, if he is not there,
     * then it adds.
     * @param user - The user we are planning to add.
     * By default, a new user is associated with an empty list of accounts.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * The method adds a new account to the user existing in the banking system.
     * @param passport - the user's passport number by which the user is identified in the banking system.
     * @param account - the bank account of the user that we plan to add to the user.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * The method searches for the user by the passport number.
     * @param passport - the user's passport number by which the user is identified in the banking system.
     * @return returns the user whose passport number matches the requested one.
     * If no such user was found, null is returned.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * This method searches the user's account by details.
     * @param passport - the user's passport number by which the user is identified in the banking system.
     * @param requisite - bank account details.
     * @return found bank account by details.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Method for transferring money from one account to another account.
     * @param srcPassport - the user's passport from whose account the funds are transferred.
     * @param srcRequisite - details of the account from which the funds are transferred.
     * @param destPassport - the user's passport to whose account the funds are transferred..
     * @param destRequisite - details of the account to which the funds are transferred.
     * @param amount the amount of funds transferred in cash equivalent.
     * @return If the account is not found or there is not enough money in the srcAccount
     * (from which the money is being transferred), then the method must return false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport,
                                 String destRequisite, double amount) {
        boolean result = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && amount >= srcAccount.getBalance()) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
        }

        return result;
    }
}
