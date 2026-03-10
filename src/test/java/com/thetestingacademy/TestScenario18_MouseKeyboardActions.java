package com.thetestingacademy;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestScenario18_MouseKeyboardActions extends WaitHelpers {
    @Description("Navigate to bookin.com, close the Genius pop-up, click flight options, click on Going and " +
            "type delhi, tab, enter, click search")
    @Test
    public  void booking_com() {
        WebDriver driver = new ChromeDriver();
     //   WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/?chal_t=1773130713241&force_referer=");

    //Closing Modal (Genius)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement close_modal = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//button[@aria-label='Dismiss sign-in info.']")));
        close_modal.click();

        WaitHelpers.tryCatchWait(3000);

    //Selecting flight
        WebElement flights  = driver.findElement(By.id("flights"));
        flights.click();

    //Cliking Going to
       WebElement Going_to = driver.findElement(By.xpath("//button[contains(@class,ShellButton)]"));
       Going_to.click();
       WaitHelpers.tryCatchWait(3000);

    //Closing Select your currency and country modal
      WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
      WebElement close_modal1 = wait.until(ExpectedConditions.elementToBeClickable
              (By.xpath("//button[@data-testid='selection-modal-close']")));
      close_modal1.click();

     //Cliking Going to again after closing modal
        WebElement Going_to1 = driver.findElement(By.xpath("//button[@data-ui-name='input_location_to_segment_0']"));
        Going_to1.click();
        WaitHelpers.tryCatchWait(3000);

     //Typing Anywhere in going to
        WebElement anywhere = driver.findElement(By.xpath("//div[text()='Anywhere']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(anywhere).sendKeys(anywhere, "Delhi").keyDown(Keys.TAB).keyUp(Keys.ENTER).perform();

        WebElement search_button = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//button[@data-ui-name='button_search_submit']")));
        search_button.click();

    // Check Flights page loaded Successfully
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Trending']")));
        Assert.assertTrue(driver.getCurrentUrl().contains("fly-anywhere"));

        driver.quit();

    }
}
