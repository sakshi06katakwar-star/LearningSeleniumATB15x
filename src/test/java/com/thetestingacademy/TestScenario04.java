package com.thetestingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario04 {
    @Test
    public void app_vwo_com() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
     // For user name
        WebElement input_box = driver.findElement(By.id("login-username")); //WebElement is an interface
        //findElement is a method coming from Remote Webdriver -> webDriver -> Search context means from search context

        input_box.sendKeys("admin@admin.com");

      // for password
      WebElement password = driver.findElement(By.name("password"));
      password.sendKeys("wrongpass@123");

      // for sign in button
     WebElement signIn_button = driver.findElement(By.id("js-login-btn"));
     signIn_button.click();

     Thread.sleep(10000);

     //Verify the error message
     WebElement error_msg = driver.findElement(By.className("notification-box-description"));
     System.out.println(error_msg.getText());

     //Assertion to verify error msg
     Assert.assertEquals(error_msg.getText(),"Your email, password, IP address or location did not match");
     driver.quit();
    //Generate HTML report - allure is used
        //Nodejs and allure command line should be installed
        //after successful running tcs we see a allure-results folder is created

    //Update testng file
    //run tcs
    //run command in terminal allure serve allure-results
    //this will give a link open that link and see your report
    //with jenkins we can share this report



    }
}
