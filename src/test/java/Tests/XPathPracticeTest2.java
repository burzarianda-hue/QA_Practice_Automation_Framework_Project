package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class XPathPracticeTest2 {

    @Test
    public void selectByClassTest() {

        WebDriver driver = new ChromeDriver(); // deschide Chrome

        // asteapta maximum 10 secunde
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // pentru click prin JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize(); // full screen
        driver.get("https://www.qapractice.com/SeleniumXPathGuide");// Deschidem pagina XPath Guide

        // TEST 2 - SELECT BY CLASS

        WebElement exercise = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='xp-q-select-by-class']")));
        exercise.click();

        WebElement xpathInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'//tag')]")));
        xpathInput.clear();

        xpathInput.sendKeys("//button[@class='btn primary']");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='xp-submit']")));
        submitButton.click();

        WebElement progress = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[@data-testid='xp-q-select-by-class']//span[@class='xp-q-num']")));

        Assert.assertEquals(progress.getText(), "2");

        //driver.quit();
      }
}