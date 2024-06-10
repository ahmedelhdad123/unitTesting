package com.unitTesting.Task.store;


import com.unitTesting.Task.account.Customer;

public interface Store {
    void buy(Product product, Customer customer);
}
