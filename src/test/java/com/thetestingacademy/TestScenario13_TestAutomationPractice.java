package com.thetestingacademy;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestScenario13_TestAutomationPractice {
    @Owner("Sakshi")
    @Description("Automate url using CSS selectors")
    @Test
    public void test_automation_practice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        //    Thread.sleep(2000);
//Handling Input box
    /*    WebElement name = driver.findElement(By.cssSelector("#name"));
        name.sendKeys("Jackson");

        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("jackson123@gmail.com");

        WebElement phone = driver.findElement(By.cssSelector("#phone"));
        phone.sendKeys("8947563548");

        WebElement address = driver.findElement(By.cssSelector("#textarea"));
        address.sendKeys("12th street, Ocean site");*/

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

//Handling Radio button
    /*    WebElement femaleRadioBtn = driver.findElement(By.cssSelector("#female"));
        femaleRadioBtn.click();*/

//Handling Check box for days
    /*    WebElement single_checkbox = driver.findElement(By.cssSelector("#sunday"));
        single_checkbox.click();*/

    List<WebElement> checkboxes = driver.findElements(By.cssSelector("#monday, #tuesday, #wednesday"));
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }
}
