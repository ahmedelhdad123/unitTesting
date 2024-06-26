package com.unitTesting.Task.store;

import com.unitTesting.Task.account.AccountManager;
import com.unitTesting.Task.account.Customer;

public class StoreImpl implements Store {

    AccountManager accountManager;

    public StoreImpl(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    @Override
    public void buy(Product product, Customer customer) {
        if (product.getQuantity() == 0) {
            throw new RuntimeException("Product out of stock");
        }

        String status = accountManager.withdraw(customer, product.getPrice());
        if (!status.equals("success")) {
            throw new RuntimeException("Payment failure: " + status);
        }
        product.setQuantity(product.getQuantity() - 1);
    }
}
