package com.thetestingacademy.DataDrivenTesting;

import org.testng.annotations.Test;

public class DataDrivenTestingExcel {
    @Test(dataProvider = "getData", dataProviderClass = UtilExcel.class)
    public void test_vwo_login(String email, String password) {
        System.out.println("email - "+email);
        System.out.println("password - "+password);

    }
}
