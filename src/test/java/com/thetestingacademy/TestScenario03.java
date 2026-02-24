package com.thetestingacademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestScenario03 {
    @Test
    public void Test_Selenium_02() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://flipkart.com");

        Assert.assertEquals(driver.getTitle(),"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");

        driver.quit();
    }
}
