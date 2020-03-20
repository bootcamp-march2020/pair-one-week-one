package day5;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CustomerTest{

    @Test
    public void testGetMobileNumber(){
        String unformattedMobileNumber = "1234567890";

        Customer customer = new Customer(unformattedMobileNumber);
        String actual = customer.getMobileNumber();

        String expectedResult = "(123) 456-7890";
        assertEquals("Customer mobile number is invalid",expectedResult,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMobileNumberShouldThrowException(){
        String unformattedMobileNumber = "123456";

        Customer customer = new Customer(unformattedMobileNumber);
    }

}