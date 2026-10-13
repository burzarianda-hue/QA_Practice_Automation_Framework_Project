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

public class XPathPracticeTest8 {

    @Test
    public void selectHeadingByTagAndTextTest() {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://www.qapractice.com/SeleniumXPathGuide");// Deschidem pagina XPath Guide

        // TEST 8 - SELECT A HEADING BY TAG AND TEXT

        WebElement exercise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-testid='xp-q-select-heading-text']")));

        js.executeScript("arguments[0].click();", exercise);

        WebElement xpathInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'//tag')]")));
        xpathInput.clear();

        xpathInput.sendKeys("//h1[text()='Welcome']");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='xp-submit']")));
        submitButton.click();

        WebElement progress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='xp-q-select-heading-text']" + "//span[@class='xp-q-num']")));

        Assert.assertEquals(progress.getText(), "8");

        driver.quit();
    }
}

