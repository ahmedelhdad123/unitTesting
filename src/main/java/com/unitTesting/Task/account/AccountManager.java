package com.unitTesting.Task.account;

public interface AccountManager {

    void deposit(Customer customer, int amount);

    String withdraw(Customer customer, int amount);

}
