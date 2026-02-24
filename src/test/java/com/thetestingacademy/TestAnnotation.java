package com.thetestingacademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestAnnotation {
    //TestNG(Test Next Generation) - Junit and Nunit have limited capabilities that's why testNG came into picture.
    //hence testNG is inspired by Junit and Nunit but with more powerful features.
    //Group Testcases, mark tcs, manage tcs and assertions.

    //Annotation - @
    //if marked @ then automatically executed by testng
    //all tcs will be run automatically
    //after @ no need to write main method

    @Test
    public void test_Selenium_01(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        //Assert.assertEquals(driver.getCurrentUrl(),"https://google.com");
        //Assert is a class with lots of assertions.
        Assert.assertEquals(driver.getTitle(),"Google");

        //AssertJ validation -
        assertThat(driver.getTitle()).isNotBlank().isNotEmpty().isNotNull().isEqualTo("Google");
        //4 assertions in 1 go
        driver.quit();
    }
}
//Que-Other than TestNG do we have any other assertion framework?
//Yes, we do have for ex. in production we use AsserJ
//it provides multiple versions of assertions.

//Que-This fn has not main method then how is this running?
//testng creates 1 xml file this xml file is nothing but testng configuration -> this testng configuration contains
//which tcs we have to run -> when we run the testng configuration automatically testng creats main method  ->
//In this main method testng will copy all the tcs written with @Test annotation -> after running tcs it will
//delete that xml file -> That's why we don't see main method but it is there.

//This testng xml file can be created by ourselves as well.
//Maven reads pom.xml and testng reads testng.xml file.
//testng.xml file is read by testng automatically and testng then figure it out what all test classes I have to run
//without this file we can't run our tc.
//Test suite - it has multiple test classes for ex. test classes related to regression or smoke or sanity etc.
//
