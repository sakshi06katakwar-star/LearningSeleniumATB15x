package com.thetestingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario09_TTA_Bank2 {
    @Test
    public void TTA_Bank2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");
        driver.manage().window().maximize();

        WebElement sign_up = driver.findElement(By.xpath("//button[text()='Sign Up']"));
        sign_up.click();

        WebElement full_name = driver.findElement(By.xpath("//input[@type='text']"));
        full_name.sendKeys("Sakshi");

        WebElement email_address = driver.findElement(By.xpath("//input[@type='email']"));
        email_address.sendKeys("sakshi@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("PassCode");

        WebElement create_ac = driver.findElement(By.xpath("//button[text()='Create Account']"));
        create_ac.click();

        Thread.sleep(5000);

        WebElement expTrackerBtn = driver.findElement(By.xpath("//button[contains(text(),'Expense')]"));
        expTrackerBtn.click();

        Thread.sleep(3000);

        //div[@class='rounded-lg bg-white/20 p-3 backdrop-blur-sm']
        //div[contains(@class,'rounded-lg bg-white')] any1 can be taken

    /*    WebElement mark = driver.findElement(By.xpath("//div[@class='rounded-lg bg-white/20 p-3 backdrop-blur-sm']"));
        Assert.assertTrue(mark.isDisplayed());*/

      WebElement Description = driver.findElement(By.xpath("//input[contains(@placeholder,'e.g. Weekly')]"));
       Description.sendKeys("Monthly SIP");

        Thread.sleep(3000);

        driver.quit();


    }
}
