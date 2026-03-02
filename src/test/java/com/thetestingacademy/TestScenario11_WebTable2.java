package com.thetestingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestScenario11_WebTable2 {
    @Test
    public void Web_Table2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement firstName = driver.findElement(By.xpath("//tr/td[text()='Cierra']"));

        WebElement dltBtn = driver.findElement(By.xpath("//span[@id='delete-record-1']"));
        dltBtn.click();

        Thread.sleep(2000);
    }
}
