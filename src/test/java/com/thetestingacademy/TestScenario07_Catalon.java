package com.thetestingacademy;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario07_Catalon {
    //Go - https://katalon-demo-cura.herokuapp.com/
    //Click on the Make appointment button, enter the username , password given
    //Verify text appointment on ui and url
    //generate report
    @Description("Validate UI with URL")
    @Test
    public void cura_healthcare() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement make_appointment = driver.findElement(By.id("btn-make-appointment"));
        make_appointment.click();

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement login_button = driver.findElement(By.id("btn-login"));
        login_button.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
        String Title_MakeAppointment = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(Title_MakeAppointment, "Make Appointment");



    }
}
