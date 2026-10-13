package Tests_Refactorizat;

import Shared_Data.Test_Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends Test_Base_Page {

    @Test
    public void metodaTest() {

        WebDriver driver = getDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.qapractice.com/practice-login-form");

        String email = "user@premiumbank.com";
        String password = "Bank@123";

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-email']")));

        emailField.sendKeys(email);

        Assert.assertEquals(emailField.getAttribute("value"), email);

        WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-password']")));

        passwordField.sendKeys(password);

        Assert.assertEquals(passwordField.getAttribute("value"), password);

        WebElement signInButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='login-submit']")));

        Assert.assertTrue(signInButton.isDisplayed());
        Assert.assertTrue(signInButton.isEnabled());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", signInButton);

        WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='login-success']")));

        Assert.assertEquals(successMessage.getText(), "Login Successful! Welcome to Premium Banking.");
    }
}