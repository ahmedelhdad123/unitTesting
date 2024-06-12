package com.unitTesting.Task.store;

import com.unitTesting.Task.account.AccountManagerImpl;
import com.unitTesting.Task.account.Customer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class StoreTest {
    Product product=new Product();
    Customer customer=new Customer();
    AccountManagerImpl accountManager=Mockito.mock(AccountManagerImpl.class);
    StoreImpl store;



    @Test void testSuccessful()
    {
        product.setQuantity(8);
//        Customer customer=new Customer(1000,true,true);
        when(accountManager.withdraw(any(),anyInt())).thenReturn("success");
        store=new StoreImpl(accountManager);
        store.buy(product,customer);
        assertThat(product.getQuantity()).isEqualTo(7);
    }

    @Test void testWithProductOutOfStock()
    {
        product.setQuantity(0);
        when(accountManager.withdraw(any(),anyInt())).thenReturn("success");
        store=new StoreImpl(accountManager);
        assertThatThrownBy(()->store.buy(product,customer)).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Product out of stock");
//        assertThrows(RuntimeException.class,()->store.buy(product,customer));
    }

//    @Disabled
    @Test void testWithPaymentFailure()
    {
        Product product = new Product(15,10);
        Customer customer = new Customer(10,false,false);
        when(accountManager.withdraw(customer,product.getPrice())).thenReturn("insufficient balance");
        store=new StoreImpl(accountManager);
        assertAll("ExpectedTest",
                () -> assertThatThrownBy(() -> store.buy(product, customer)).isInstanceOf(RuntimeException.class)
                        .hasMessage("Payment failure: insufficient balance"),
                () -> assertThat(customer.getBalance()).isEqualTo(10)

        );
//        assertThatThrownBy(() -> store.buy(product, customer)).isInstanceOf(RuntimeException.class)
//                .hasMessage("Payment failure: insufficient balance");
//        assertThat(customer.getBalance()).isEqualTo(10);
    }

}
