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

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.qapractice.com/practice-different-ui-elements");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String textFieldData = "Test QA";

        WebElement textField = driver.findElement(By.id("textField"));
        textField.sendKeys(textFieldData);

        Assert.assertEquals(textField.getAttribute("value"), textFieldData);

        String textAreaData = "Acesta este un test pentru Text Area.";


        WebElement textArea = driver.findElement(By.id("textArea"));
        textArea.sendKeys(textAreaData);

        Assert.assertEquals(textArea.getAttribute("value"), textAreaData);


        WebElement button = driver.findElement(By.id("ui-click-button"));

        Assert.assertTrue(button.isDisplayed());

        js.executeScript("arguments[0].click();", button);


        WebElement checkbox = driver.findElement(By.id("ui-single-checkbox"));

        js.executeScript("arguments[0].click();", checkbox);

        Assert.assertTrue(checkbox.isSelected());

        WebElement radioButton = driver.findElement(By.id("ui-radio-Radio 1"));


        js.executeScript("arguments[0].click();", radioButton);

        Assert.assertTrue(radioButton.isSelected());

        WebElement dropdown = driver.findElement(By.id("singleDropdown"));

        Select select = new Select(dropdown);

        select.selectByVisibleText("Canada");


        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Canada");


        WebElement multiDropdown = driver.findElement(By.id("multiDropdown"));

        Select multiSelect = new Select(multiDropdown);

        multiSelect.selectByVisibleText("Option A");

        multiSelect.selectByVisibleText("Option B");

        Assert.assertTrue(multiSelect.getOptions().get(0).isSelected());

        Assert.assertTrue(multiSelect.getOptions().get(1).isSelected());

        driver.quit();
    }
}

