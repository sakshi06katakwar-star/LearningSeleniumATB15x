package com.thetestingacademy;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestScenario14_DatePickerFormat01 {
    @Description("Write a generic Date Picker code where user enters any date (mm/dd/yyyy)")
    @Test
    public void selectDate() throws InterruptedException {
        String inputDate = "04/15/2026";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/"); {
        }

        // Example input: 04/15/2026
        String[] dateParts = inputDate.split("/");

        String month = dateParts[0];
        String day = dateParts[1];
        String year = dateParts[2];

        // Open calendar
        driver.findElement(By.id("datepicker")).click();

        // wait until date is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement date = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='15']")));
        date.click();

        // Convert month number to month name
        String monthName = getMonthName(day);

        // Navigate to expected month and year
        while (true) {
            String expectedMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText();

            if (expectedMonthYear.equals(monthName + " " + year)) {
                break;
            }
            driver.findElement(By.xpath("//span[text()='Next']")).click();

            //Select the day
            driver.findElement(By.xpath("//a[text()='" + day + "']")).click();
        }
    }

    //Method to Convert Month Number → Month Name
    public String getMonthName(String month) {

        switch (month) {
            case "01":
                return "January";
            case "02":
                return "February";
            case "03":
                return "March";
            case "04":
                return "April";
            case "05":
                return "May";
            case "06":
                return "June";
            case "07":
                return "July";
            case "08":
                return "August";
            case "09":
                return "September";
            case "10":
                return "October";
            case "11":
                return "November";
            case "12":
                return "December";
        }

        return "";
    }
}

