package com.unitTesting.Task.store;

import com.unitTesting.Task.account.AccountManagerImpl;
import com.unitTesting.Task.account.Customer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class StoreTest {
    Product product=new Product();
    Customer customer=new Customer();
    AccountManagerImpl accountManager=Mockito.mock(AccountManagerImpl.class);
    StoreImpl store=Mockito.mock(StoreImpl.class);



    @Test void testSuccessful()
    {
        product.setQuantity(8);
//        Customer customer=new Customer(1000,true,true);
        when(accountManager.withdraw(any(),anyInt())).thenReturn("success");
        store=new StoreImpl(accountManager);
        store.buy(product,customer);
        assertEquals(7,product.getQuantity());
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

    @Disabled
    @Test void testWithPaymentFailure()
    {
        Product product = new Product(10, 8);
        when(accountManager.withdraw(any(),anyInt())).thenReturn("maximum credit exceeded");

        assertThatThrownBy(() -> store.buy(product, customer))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Payment failure: maximum credit exceeded");
    }

}
