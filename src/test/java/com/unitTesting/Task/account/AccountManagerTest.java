package com.unitTesting.Task.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountManagerTest {

    AccountManagerImpl accountManager=new AccountManagerImpl();

    @Test  void testCustomerWithSufficientBalance ()
    {
        Customer customer=new Customer(1000,true,true);
        String result=accountManager.withdraw(customer,700);

        int expected=customer.getBalance();
        assertAll("ExpectedTest",
                () -> assertEquals(300,expected,"ExpectedBalance Not Match"),
                () -> assertEquals("success",result,"Result Not matched")
        );
//        assertEquals(300,expected);
//        assertEquals("success",result);
//        assertTrue("success".equals(result));
    }
    @Test void testCustomerWithCreditAllowed()
    {
        Customer customer=new Customer(500,false,true);
        String result=accountManager.withdraw(customer,700);
        assertEquals("success",result);
    }
    @Test void testCustomerWithNotCreditAllowed()
    {
        Customer customer=new Customer(500,false,false);
        String result=accountManager.withdraw(customer,700);
        assertEquals("insufficient account balance",result);
    }

    @Test void testCustomerWithExpectedBalanceMoreTHanCreditAndNotVip()
    {
        Customer customer=new Customer(500,false,true);
        String result=accountManager.withdraw(customer,2000);
        assertEquals("maximum credit exceeded",result);
    }
}
