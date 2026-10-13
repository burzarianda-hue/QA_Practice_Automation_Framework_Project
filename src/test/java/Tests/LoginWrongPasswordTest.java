package Tests;

import Pages.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginWrongPasswordTest {

    @Test
    public void metodaTest() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.get("https://www.qapractice.com/practice-login-form");

        LoginPage loginPage = new LoginPage(driver);


        String email = "user@premiumbank.com";
        String password = "ParolaGresita1";

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='login-email']")));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        passwordField.sendKeys(password);

        WebElement signInButton = driver.findElement(By.xpath("//button[@id='login-submit']"));
        js.executeScript("arguments[0].click();", signInButton);

        boolean successAppeared;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[@data-testid='login-success']")));
            successAppeared = true;
        } catch (TimeoutException e) {
            successAppeared = false;
        }

        // Verificăm mesajul afișat pentru parola greșită.
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email id and password");

        driver.quit();
    }
}