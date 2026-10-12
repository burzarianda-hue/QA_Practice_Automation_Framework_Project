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

        WebDriver driver = new ChromeDriver(); //deschide Chrome

        //asteapta; maxim 10 secunde, se opreste cand elementul e gata;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver; // pentru click prin JavaScript;

        driver.manage().window().maximize();//full screen

        //pornim de la pagina de login, ca un utilizator real
        driver.get("https://www.qapractice.com/practice-login-form");

        //Datele de test
        String email = "ari_test@net.com";
        String password = "Parola@123#";//parola respecta regurile de pe site: +8 caractere, litera mare, litara mica, cifra, caractere speciale

        //Intram pe REGISTRATION
        //link-ul "Register now" de pe pagina de login;
        WebElement registerNow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='login-register']")));
        js.executeScript("arguments[0].click();", registerNow);

        //Email
        //asteptam sa apara formularul (primul camp), apoi scriem in el;
        WebElement emailFiled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='register-email']")));
        emailFiled.sendKeys(email);

        //verificam ca s-a scris ce trebuie (getAttribute("value") = ce e scris in camp)
        Assert.assertEquals(emailFiled.getAttribute("value"),"ari_test@net.com");

        //PASSWORD
        //primul camp de tip password din pagina
        WebElement passwordField = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
        passwordField.sendKeys(password);

        //CONFIRM PASSWORD
        // al doilea camp de tip password din pagina
        WebElement confirmPasswordFiled = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
        confirmPasswordFiled.sendKeys(password);

        //REGISTER
        WebElement registerButton = driver.findElement(By.xpath("//button[@id='register-submit']"));

        Assert.assertTrue(registerButton.isDisplayed());//butonul se vede?
        Assert.assertTrue(registerButton.isEnabled());//butonul poate fi apasat?

        js.executeScript("arguments[0].click();", registerButton);



        // VERIFICARE
        // Asteptam sa apara mesajul de succes
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='register-success']")));

        // Mesajul asteptat
        String mesajAsteptat = "Registration Successful";

        // Verificam mesajul afisat
        Assert.assertEquals(successMessage.getText(), mesajAsteptat);

        //driver.quit();//inchide browserul


    }
}
