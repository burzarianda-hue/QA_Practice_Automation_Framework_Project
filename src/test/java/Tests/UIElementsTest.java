package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class UIElementsTest {

    @Test
    public void metodaTest() {

        // Deschidem browserul Chrome
        WebDriver driver = new ChromeDriver();

        // Deschidem pagina UI Elements
        driver.get("https://www.qapractice.com/practice-different-ui-elements");

        // Maximizăm fereastra browserului
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // JavaScript Executor
        // Îl folosim pentru elementele la care click-ul normal este blocat
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1. TEXT FIELD
        // Datele pe care vrem să le introducem
        String textFieldData = "Test QA";

        // Identificăm Text Field
        WebElement textField = driver.findElement(By.id("textField"));
        textField.sendKeys(textFieldData);

        // Verificăm dacă textul introdus este corect
        Assert.assertEquals(textField.getAttribute("value"), textFieldData);

        // 2. TEXT AREA

        // Datele pe care vrem să le introducem
        String textAreaData = "Acesta este un test pentru Text Area.";

        // Identificăm Text Area
        WebElement textArea = driver.findElement(By.id("textArea"));
        textArea.sendKeys(textAreaData);// Introducem textul

        // Verificăm textul introdus
        Assert.assertEquals(textArea.getAttribute("value"), textAreaData);

        // 3. BUTTON

        // Identificăm butonul
        WebElement button = driver.findElement(By.id("ui-click-button"));

        // Verificăm că butonul este afișat
        Assert.assertTrue(button.isDisplayed());

        // Apăsăm butonul cu JavaScript
        js.executeScript("arguments[0].click();", button);


        // 4. CHECKBOX
        // Identificăm checkbox-ul
        WebElement checkbox = driver.findElement(By.id("ui-single-checkbox"));

        // Apăsăm checkbox-ul cu JavaScript
        js.executeScript("arguments[0].click();", checkbox);

        // Verificăm dacă checkbox-ul este selectat
        Assert.assertTrue(checkbox.isSelected());


        // 5. RADIO BUTTON
        // Identificăm Radio 1
        WebElement radioButton = driver.findElement(By.id("ui-radio-Radio 1"));

        // Selectăm Radio 1 cu JavaScript
        js.executeScript("arguments[0].click();", radioButton);

        // Verificăm dacă Radio 1 este selectat
        Assert.assertTrue(radioButton.isSelected());


        // 6. DROPDOWN
        // Identificăm dropdown-ul
        WebElement dropdown = driver.findElement(By.id("singleDropdown"));

        // Folosim clasa Select pentru dropdown
        Select select = new Select(dropdown);

        // Selectăm Canada
        select.selectByVisibleText("Canada");

        // Verificăm dacă Canada a fost selectată
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Canada");

        // 7. MULTI DROPDOWN

        // Identificăm Multi Dropdown
        WebElement multiDropdown = driver.findElement(By.id("multiDropdown"));

        // Folosim clasa Select pentru Multi Dropdown
        Select multiSelect = new Select(multiDropdown);

        // Selectăm Option A
        multiSelect.selectByVisibleText("Option A");

        // Selectăm Option B
        multiSelect.selectByVisibleText("Option B");

        // Verificăm că Option A este selectată
        Assert.assertTrue(multiSelect.getOptions().get(0).isSelected());

        // Verificăm că Option B este selectată
        Assert.assertTrue(multiSelect.getOptions().get(1).isSelected());



        // Închidem browserul
       // driver.quit();
    }
}

