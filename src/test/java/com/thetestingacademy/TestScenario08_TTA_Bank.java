package com.thetestingacademy;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestScenario08_TTA_Bank {
    @Owner("Sakshi")
    @Severity(SeverityLevel.BLOCKER)
   // @TmsLink("")
    @Description("Verify the flow of TTA banking application")
    @Test
    public void TTA_Bank() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");

        WebElement sign_up = driver.findElement(By.xpath("//button[text()='Sign Up']"));
        sign_up.click();

       WebElement full_name = driver.findElement(By.xpath("//input[@type='text']"));
        full_name.sendKeys("Sakshi");

        WebElement email_address = driver.findElement(By.xpath("//input[@type='email']"));
        email_address.sendKeys("sakshi@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys();
    }
}
