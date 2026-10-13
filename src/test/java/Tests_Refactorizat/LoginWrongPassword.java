package Tests_Refactorizat;

import Pages.LoginPage;
import Shared_Data.Test_Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginWrongPassword extends Test_Base_Page {

    @Test
    public void metodaTest() {

        WebDriver driver = getDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.qapractice.com/practice-login-form");

        LoginPage loginPage = new LoginPage(driver);

        String email = "user@premiumbank.com";
        String password = "ParolaGresita1";

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='login-email']")));

        emailField.sendKeys(email);

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='login-password']")));

        passwordField.sendKeys(password);

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@id='login-submit']")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", signInButton);

        boolean successAppeared;

        try {
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(3)
            ).until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[@data-testid='login-success']")));

            successAppeared = true;

        } catch (TimeoutException e) {
            successAppeared = false;
        }

        Assert.assertFalse(successAppeared, "Mesajul de login reușit nu trebuie să apară pentru parola greșită.");

        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email id and password");
    }
}