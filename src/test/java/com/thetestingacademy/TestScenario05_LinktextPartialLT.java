package com.thetestingacademy;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//Validate start free trial text using Linktext and Partial linktext

public class TestScenario05_LinktextPartialLT {
    @Description("Verify negative tcs for created account")
    @Test
    public  void app_vwo_com() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");

        //Since start a free trial is a link so it has anchor tag /a so we can use text
       //Link text
    //    WebElement link = driver.findElement(By.linkText("Start a free trial"));
    //    link.click();

        //partial linktext
        WebElement link = driver.findElement(By.partialLinkText("Start"));
        link.click();
    }

}
