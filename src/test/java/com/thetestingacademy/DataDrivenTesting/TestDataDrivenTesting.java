package com.thetestingacademy.DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataDrivenTesting {
    @DataProvider(name = "loginData", parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                new Object[]{"abcd@gmail.com", "abcd123"},
                new Object[]{"abcde@gmail.com", "abcde1234"},
                new Object[]{"abcdf@gmail.com", "abcdf1235"}
    } ;
}

    @Test(dataProvider = "loginData")
    public void loginTest(String email, String password) {
        System.out.println(email +" | "+ password);

    }
}
