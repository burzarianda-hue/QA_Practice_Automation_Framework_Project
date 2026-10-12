package HelperMethods;

// Importuri Selenium folosite pentru metodele de interacțiune cu elementele.
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;


// Această clasă conține metode reutilizabile pentru elementele de pe pagină.
// Scopul este să nu repetăm același cod în fiecare Page.
public class ElementsMethods {

    // Driver-ul controlează browserul.
    WebDriver driver;


    // Constructorul primește driver-ul din test/page.
    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
    }


    // Așteaptă ca elementul să devină vizibil.
    // Folosim un wait de maximum 5 secunde.
    private void waitVisibility(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    // Metodă reutilizabilă pentru click.
    // JavaScript este folosit pentru a aduce elementul în zona vizibilă.
    public void clickOnElement(WebElement element) {

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                element
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                element
        );
    }


    // Selectează un element dintr-o listă după text.
    public void selectElementFromListByText(List<WebElement> listWebElement, String text) {

        for (int i = 0; i < listWebElement.size(); i++) {

            if (listWebElement.get(i).getText().equals(text)) {

                clickOnElement(listWebElement.get(i));
                break;
            }
        }
    }


    // Introduce text într-un câmp.
    public void enterText(WebElement element, String text) {

        // Așteptăm ca elementul să fie vizibil.
        waitVisibility(element);

        // Ștergem eventualul text existent.
        element.clear();

        // Introducem textul primit.
        element.sendKeys(text);
    }


    // Face scroll în josul paginii.
    public void scrollDownInPage() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 200);");
    }


    // Introduce text și apoi apasă Enter.
    public void enterTextWithEnter(WebElement element, String text) {

        waitVisibility(element);

        element.clear();

        element.sendKeys(text);

        element.sendKeys(Keys.ENTER);
    }


    // Încarcă o imagine într-un element de tip upload.
    public void uploadPicture(WebElement element) {

        File photo = new File("src/test/resources/poza_curs.jpg");

        element.sendKeys(photo.getAbsolutePath());
    }


    // Introduce text folosind Actions.
    public void enterTextUsingActions(WebElement element, String text) {

        Actions actions = new Actions(driver);

        actions.sendKeys(text).perform();

        waitVisibility(element);

        actions.sendKeys(Keys.ENTER).perform();
    }


    // Permite selectarea mai multor valori dintr-o listă.
    public void clickMultipleValues(
            List<WebElement> webElements,
            List<String> values) {

        for (String value : values) {

            for (WebElement webElement : webElements) {

                if (webElement.getText().equals(value)) {

                    String name = webElement.getText();

                    webElement.click();
                }
            }
        }
    }


    // Selectează o valoare dintr-un dropdown după textul afișat.
    public void selectByText(WebElement element, String text) {

        Select dropDown = new Select(element);

        dropDown.selectByVisibleText(text);
    }


    // Selectează o valoare dintr-un dropdown după atributul value.
    public void selectByValue(WebElement element, String text) {

        Select dropDown = new Select(element);

        dropDown.selectByValue(text);
    }
}
