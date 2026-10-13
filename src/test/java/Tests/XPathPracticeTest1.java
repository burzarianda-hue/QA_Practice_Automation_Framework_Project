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

public class XPathPracticeTest1 {

    @Test
    public void selectByIdTest() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize(); // full screen
        driver.get("https://www.qapractice.com/SeleniumXPathGuide");

        // TEST 1 - SELECT BY ID
        WebElement exercise = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='xp-q-select-by-id']")));
        exercise.click();

        WebElement xpathInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'//tag')]")));
        xpathInput.clear();

        xpathInput.sendKeys("//input[@id='username']");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='xp-submit']")));
        submitButton.click();

        WebElement progress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='xp-q-select-by-id']//span[@class='xp-q-num']")));

        Assert.assertEquals(progress.getText(), "1");

        driver.quit();



    }
}