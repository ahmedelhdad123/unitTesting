package com.unitTesting.Task.account;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class AccountManagerTest {

    AccountManagerImpl accountManager=new AccountManagerImpl();

    @Test  void testCustomerWithSufficientBalance () {
        Customer customer=new Customer(1000,true,true);
        String result=accountManager.withdraw(customer,700);

        int expected=customer.getBalance();
        assertAll("ExpectedTest",
//                () -> assertEquals(300,expected,"ExpectedBalance Not Match"),
//                () -> assertEquals("success",result,"Result Not matched")
                () -> assertThat(expected).as("ExpectedBalance Not Match").isEqualTo(300),
                () -> assertThat(result).as("Result Not matched").isEqualTo("success")
        );
//        assertEquals(300,expected);
//        assertEquals("success",result);
//        assertTrue("success".equals(result));
    }
    @Test void testCustomerWithCreditAllowed() {
        Customer customer=new Customer(500,false,true);
        String result=accountManager.withdraw(customer,700);
//        assertEquals("success",result);
        assertThat(result).as("Result does not match").isEqualTo("success");

    }

    @Test void testCustomerWithNotCreditAllowed() {
        Customer customer=new Customer(500,false,false);
        String result=accountManager.withdraw(customer,700);
//        assertEquals("insufficient account balance",result);
        assertThat(result).as("Result does not match").isEqualTo("insufficient account balance");
    }

    @Test void testCustomerWithExpectedBalanceLessThanCreditAndVip(){
        Customer customer=new Customer(500,true,true);
        customer.setMaxCredit(1000);
        String result=accountManager.withdraw(customer,700);
//        assertEquals("success",result);
        assertThat(result).as("Result does not match").isEqualTo("success");
    }
    @Test void testCustomerWithExpectedBalanceMoreTHanCreditAndNotVip() {
        Customer customer=new Customer(500,false,true);
        customer.setMaxCredit(1000);
        String result=accountManager.withdraw(customer,2000);
//        assertEquals("maximum credit exceeded",result);
        assertThat(result).as("Result does not match").isEqualTo("maximum credit exceeded");
    }


}
