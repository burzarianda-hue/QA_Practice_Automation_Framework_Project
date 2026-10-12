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

public class XPathPracticeTest7 {

    @Test
    public void selectImageByAltTest() {

        WebDriver driver = new ChromeDriver(); // deschide Chrome

        // asteapta maximum 10 secunde
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // pentru click prin JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize(); // full screen

        driver.get("https://www.qapractice.com/SeleniumXPathGuide");
        // Deschidem pagina XPath Guide

        // TEST 7 - SELECT AN IMAGE BY ALT TEXT

        // Selectam butonul exercitiului 7
        WebElement exercise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-testid='xp-q-select-image-alt']")));

        // Facem click prin JavaScript
        js.executeScript("arguments[0].click();", exercise);

        // CAMPUL PENTRU XPATH
        WebElement xpathInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'//tag')]")));
        xpathInput.clear();

        // XPath-ul corect pentru imagine
        xpathInput.sendKeys("//img[@alt='Blue Backpack']");

        // SUBMIT
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='xp-submit']")));
        submitButton.click();

        // VERIFICARE
        WebElement progress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='xp-q-select-image-alt']" + "//span[@class='xp-q-num']")));

        // Assert
        Assert.assertEquals(progress.getText(), "7");

        //driver.quit();
    }
}

