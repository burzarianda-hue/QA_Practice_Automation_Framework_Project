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

public class XPathPracticeTest5 {

    @Test
    public void selectCheckboxTest() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://www.qapractice.com/SeleniumXPathGuide");

        // TEST 5 - SELECT A CHECKBOX

        WebElement exercise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-testid='xp-q-select-checkbox']")));

        js.executeScript("arguments[0].click();", exercise);

        WebElement xpathInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'//tag')]")));
        xpathInput.clear();

        xpathInput.sendKeys("//input[@id='news']");


        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='xp-submit']")));
        submitButton.click();


        WebElement progress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='xp-q-select-checkbox']" + "//span[@class='xp-q-num']")));

        Assert.assertEquals(progress.getText(), "5");

        driver.quit();
    }
}

