package com.thetestingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;

public class TestScenario20_VWOautomation  {
    @Test

    public void vwo_complete_signup() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");

//step 1. click on Start a free trial
    WebElement start_a_free_trial = driver.findElement(By.xpath("//span[text()='Start a FREE TRIAL']"));
    start_a_free_trial.click();

    String parentWindow = driver.getWindowHandle();
    Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
            }
        }

//step 2. Check next page loaded Successfully
    Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));

//step 3. Validate error msg
  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
/*  WebElement bussiness_email = driver.findElement(By.xpath("//input[@id='page-v1-step1-email']"));
  bussiness_email.sendKeys("abcd@gmail");

  WebElement error_msg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'invalid-reason')]")));
  Assert.assertEquals(error_msg.getText(),"The email address you entered is incorrect.");*/

//step 4. Create a free trial account
   WebElement bussnessEmail = driver.findElement(By.xpath("//input[@id='page-v1-step1-email']"));
   bussnessEmail.sendKeys("kvhhxt5381@itdbe.com");

   WebElement checkBox = driver.findElement(By.xpath("//input[contains(@id,'page-free-trial')]"));
   checkBox.click();

   WebElement free_trial_account = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create a Free Trial Account']")));
   free_trial_account.click();

//step 5. Create Account
    WebElement first_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='page-v1-fname']")));
    first_name.sendKeys("Vritika");

    WebElement last_name = driver.findElement(By.id("page-v1-lname"));
    last_name.sendKeys("Sharma");

    WebElement phone_num = driver.findElement(By.id("page-v1-pnumber"));
    phone_num.sendKeys("9854764583");

    WebElement checkbox = driver.findElement(By.id("page-free-trial-step2-cu-gdpr-consent-checkbox"));

        if(!checkbox.isSelected()) {
            checkbox.click();
        }

    WebElement create_acc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create Account']")));
    create_acc.click();

//step 6. skip and continue to app
    WebElement skipBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(@data-step,'free-trial-thankyou')]")));
    skipBtn.click();

//step 7. click save
    WebElement continue_setup = wait.until(ExpectedConditions.elementToBeClickable
            (By.xpath("//button[@vwo-async-click='vm.continueSetup()']")));
    if(!continue_setup.isSelected()) {
        continue_setup.click();
    }




    }
}
