package com.unitTesting.Task;

import com.unitTesting.Task.account.AccountManager;
import com.unitTesting.Task.account.AccountManagerImpl;
import com.unitTesting.Task.account.Customer;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(500, false, false);
        AccountManagerImpl accountManager = new AccountManagerImpl();
        accountManager.withdraw(customer,700);
    }

}