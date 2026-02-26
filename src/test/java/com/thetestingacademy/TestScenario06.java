package com.thetestingacademy;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario06 {
    //Negative scenario - Navigate to app.vwo.com
    //click on Start a free trial
    //provide wrong email
    //click check box
    //click Create a free trial account
    //Validate error message

    @Owner("Sakshi")
 //   @TmsLink("")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify the error message after typing wrong email id and password")
    @Test
    public void vwo_free_trial_error_verify() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage");

        Thread.sleep(5000);

    //    WebElement free_trial_link = driver.findElement(By.partialLinkText("Start"));
    //    free_trial_link.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));
        //this assertion will verify that after clicking Start a... link "free-trial" text is visible in new opened link

        WebElement bussiness_email = driver.findElement(By.id("page-v1-step1-email"));
        bussiness_email.sendKeys("admin");

        WebElement check_box = driver.findElement(By.name("gdpr_consent_checkbox"));
        check_box.click();

        WebElement create_free_ac = driver.findElement(By.tagName("button"));
        create_free_ac.click();

        WebElement error_msg = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(error_msg.getText(),"The email address you entered is incorrect.");

    }


}
