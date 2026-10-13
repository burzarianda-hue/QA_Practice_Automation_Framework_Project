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

public class RegistrationForm extends Test_Base_Page {

    @Test
    public void metodaTest() {

        WebDriver driver = getDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://www.qapractice.com/practice-login-form");

        String email = "ari_test@net.com";
        String password = "Parola@123#";

        WebElement registerNow = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@id='login-register']")));

        js.executeScript("arguments[0].click();", registerNow);

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='register-email']")));

        emailField.sendKeys(email);

        Assert.assertEquals(emailField.getAttribute("value"), email);

        WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//input[@type='password'])[1]")));

        passwordField.sendKeys(password);

        WebElement confirmPasswordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//input[@type='password'])[2]")));

        confirmPasswordField.sendKeys(password);

        WebElement registerButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@id='register-submit']")));

        Assert.assertTrue(registerButton.isDisplayed());
        Assert.assertTrue(registerButton.isEnabled());

        js.executeScript("arguments[0].click();", registerButton);

        WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@data-testid='register-success']")));

        Assert.assertEquals(successMessage.getText(), "Registration Successful");
    }
}