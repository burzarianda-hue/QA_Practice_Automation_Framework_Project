package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


// Această clasă conține metode reutilizabile pentru alertele Selenium.
public class AlertMethods {

    // Driver-ul controlează browserul.
    WebDriver driver;

    // WebDriverWait este folosit pentru a aștepta apariția alertei.
    WebDriverWait wait;


    // Constructorul primește driver-ul.
    public AlertMethods(WebDriver driver) {

        this.driver = driver;
    }


    // Acceptă alerta apăsând butonul OK.
    public void alertOk() {

        Alert alertOk = driver.switchTo().alert();

        alertOk.accept();
    }


    // Așteaptă apariția alertei pentru numărul de secunde primit.
    public void alertWithDelay(int seconds) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

        wait.until(ExpectedConditions.alertIsPresent());

        alertOk();
    }


    // Confirmă alerta.
    public void alertConfirm() {

        Alert alertConfirm = driver.switchTo().alert();

        alertConfirm.accept();
    }


    // Anulează alerta apăsând Cancel.
    public void alertCancel() {

        Alert alertCancel = driver.switchTo().alert();

        alertCancel.dismiss();
    }


    // Introduce text într-o alertă de tip prompt și o confirmă.
    public void alertText(String value) {

        Alert alertText = driver.switchTo().alert();

        alertText.sendKeys(value);

        alertText.accept();
    }
}
