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

public class RegistrationFormTest {

    @Test
    public void metodaTest() {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.get("https://www.qapractice.com/practice-login-form");

        String email = "ari_test@net.com";
        String password = "Parola@123#";

        WebElement registerNow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='login-register']")));
        js.executeScript("arguments[0].click();", registerNow);


        WebElement emailFiled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='register-email']")));
        emailFiled.sendKeys(email);

        Assert.assertEquals(emailFiled.getAttribute("value"),"ari_test@net.com");


        WebElement passwordField = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
        passwordField.sendKeys(password);


        WebElement confirmPasswordFiled = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
        confirmPasswordFiled.sendKeys(password);

        WebElement registerButton = driver.findElement(By.xpath("//button[@id='register-submit']"));

        Assert.assertTrue(registerButton.isDisplayed());
        Assert.assertTrue(registerButton.isEnabled());

        js.executeScript("arguments[0].click();", registerButton);


        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='register-success']")));

        String mesajAsteptat = "Registration Successful";


        Assert.assertEquals(successMessage.getText(), mesajAsteptat);

        driver.quit();


    }
}