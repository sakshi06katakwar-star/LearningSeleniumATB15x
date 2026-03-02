package com.thetestingacademy;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
//Login, Find the first Terminated Employee and click on the Delete
public class TestScenario10_WebTable {
    @Test
    @Description("Login, Find the first Terminated Employee and click on the Delete")
    public void web_table() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php");
        driver.manage().window().maximize();
        Thread.sleep(2000);

    //    WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
    //    username.sendKeys("admin");

        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("admin");

     //   WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
       // password.sendKeys("Hacker@4321");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Hacker@4321");

   //     WebElement loginBtn  = driver.findElement(By.xpath("//button"));
     //   loginBtn.click();

        WebElement loginBtn  = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        Thread.sleep(3000);

        WebElement rowContains_1stTerminatedEmp = driver.findElement(By.xpath("//div[@class='oxd-table-card'][2]/div/div[@role='cell'][6]"));

       WebElement dltBtn = driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']"));
        dltBtn.click();

        Thread.sleep(3000);

      //  driver.quit();


    }
}
