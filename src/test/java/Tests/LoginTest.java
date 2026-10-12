package Tests;
//IMPORT = aducem din biblioteci ce avem nevoie;
import org.openqa.selenium.By;              //By = cum cautam un element(xpath,id...);
import org.openqa.selenium.JavascriptExecutor;//ne lasa sa rulam JavaScript in pagina;
import org.openqa.selenium.WebDriver;         //WebDriver = telecomanda browserului;
import org.openqa.selenium.WebElement;        //WebElement = un element de pe pagina;
import org.openqa.selenium.chrome.ChromeDriver;//ChromeDriver = telecomanda pentru Chrome;
import org.openqa.selenium.support.ui.ExpectedConditions;//conditii de asteptare;
import org.openqa.selenium.support.ui.WebDriverWait;//asteptarea inteligenta (fara sleep);
import org.testng.Assert;                      //Assert = verificarea rezultatului;
import org.testng.annotations.Test;            //@Test = eticheta pentru test;

import javax.management.DynamicMBean;
import java.time.Duration;
import java.time.Instant;

//Clasa = "cutia" in care tinem testul
public class LoginTest {
    //@Test = TestNG stie ca metoda de mai jos e un test si o ruleaza;
    @Test
    public void metodaTest() {

        //VARIABILA = o cutie cu nume. Tipul (WebDriver) spune ce tinem in ea;
        //"mew ChromeDriver()" = creaza un obiect nou = se deschide Chrome;
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //wait = "asteapta maxim 10 secunde, dar opreste_te imediat ce elementul e gata";
        //(inlocuieste Thread.sleep, care asteapta mereu un timp fix);

        //transformam driverul in "executor de JavaScript" (il folosim la click);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0, 200);");

        driver.manage().window().maximize();//full screen
        driver.get("https://www.qapractice.com/practice-login-form");

        //Datele de test (String = text);
        String email = "user@premiumbank.com";
        String password = "Bank@123";

        // Email Address";
        //findElement = cauta elementul pe pagina; By.xpath = "adresa" lui;
        //Aici asteptam sa fie vizibil campul, apoi il punem in variabil emailFiled
        WebElement emailFiled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-email']")));
        emailFiled.sendKeys(email);

        //verificam ca in camp s-a scris ce trebuia;
        //(getAttribute("value") = ce e scris in camp);
        Assert.assertEquals(emailFiled.getAttribute("value"), "user@premiumbank.com");

        // Password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        passwordField.sendKeys(password);

        Assert.assertEquals(passwordField.getAttribute("value"), "Bank@123");


        // Remember me
        // WebElement rememberMe = driver.findElement(By.xpath("//input[@id='login-remember']"));
        // rememberMe.click();


        // Forgot password
        // WebElement forgotPassword = driver.findElement(By.xpath("//a[@id='login-forgot-password']"));
        // forgotPassword.click();


        // Sign in
        WebElement signInButton = driver.findElement(By.xpath("//button[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed());//butonul se vede pe ecran?;
        Assert.assertTrue(signInButton.isEnabled());//butonul poate fi apasat?;

        //click prin JavaScript (arguments[0] = elementul pe care il dam mai departe)
        js.executeScript("arguments[0].click();", signInButton);

        // Verificare login
        //in loc de Thread.seep: asteptam ca mesajul de succes sa apara;
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='login-success']")));

        Assert.assertEquals(successMessage.getText(), "Login Successful! Welcome to Premium Banking.");


        // Register now
        // WebElement registerNow = driver.findElement(By.xpath("//a[@id='login-register']"));
        // registerNow.click();


        driver.quit();//inchide browswerul
    }
}


//        EmailAddress           emailField	         //input[@id='login-email']
//        Password	             passwordField	    //input[@id='login-password']
//        Remember me	         rememberMe     	//input[@id='login-remember']
//        Forgot password?  	forgotPassword  	//a[@id='login-forgot-password']
//        Register now          registerNow         //a[@id='login-register']


