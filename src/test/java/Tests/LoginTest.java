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
import javax.management.DynamicMBean;
import java.time.Duration;
import java.time.Instant;


public class LoginTest {

    @Test
    public void metodaTest() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0, 200);");

        driver.manage().window().maximize();
        driver.get("https://www.qapractice.com/practice-login-form");

        String email = "user@premiumbank.com";
        String password = "Bank@123";

        WebElement emailFiled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-email']")));
        emailFiled.sendKeys(email);

        Assert.assertEquals(emailFiled.getAttribute("value"), "user@premiumbank.com");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        passwordField.sendKeys(password);

        Assert.assertEquals(passwordField.getAttribute("value"), "Bank@123");


        // Remember me
        // WebElement rememberMe = driver.findElement(By.xpath("//input[@id='login-remember']"));
        // rememberMe.click();


        // Forgot password
        // WebElement forgotPassword = driver.findElement(By.xpath("//a[@id='login-forgot-password']"));
        // forgotPassword.click();

        WebElement signInButton = driver.findElement(By.xpath("//button[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed());
        Assert.assertTrue(signInButton.isEnabled());


        js.executeScript("arguments[0].click();", signInButton);


        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='login-success']")));

        Assert.assertEquals(successMessage.getText(), "Login Successful! Welcome to Premium Banking.");


        // WebElement registerNow = driver.findElement(By.xpath("//a[@id='login-register']"));
        // registerNow.click();


        driver.quit();
    }
}


