package com.thetestingacademy;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestScenario17_techlistic extends CommonToAll {
    @Description("Automate the form")
    @Test
    public void form() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        openBrowser(driver,"https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("Sakshi");

        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Katakwar");

        driver.findElement(By.id("sex-1")).click();

        driver.findElement(By.id("exp-5")).click();

        driver.findElement(By.id("datepicker")).sendKeys("08/03/2026");

        driver.findElement(By.id("profession-1")).click();

        driver.findElement(By.id("tool-2")).click();

        List<WebElement> DropDown = driver.findElements(By.id("continents"));
        for(WebElement DropDownList :DropDown) {
            if(!DropDownList.isSelected()) {
                DropDownList.sendKeys("Africa");
            }

        }

        driver.findElement(By.cssSelector("#selenium_commands option:nth-child(3)")).click();
    }
}
