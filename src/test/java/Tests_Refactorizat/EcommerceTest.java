package Tests_Refactorizat;

import Shared_Data.Test_Base_Page;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EcommerceTest extends Test_Base_Page {

    @Test
    public void metodaTest() {

        WebDriverWait wait = new WebDriverWait(
                getDriver(),
                Duration.ofSeconds(10)
        );

        JavascriptExecutor js =
                (JavascriptExecutor) getDriver();

        // 1. Deschidem pagina magazinului
        getDriver().get("https://www.qapractice.com/practice-ecommerece-website");

        // 2. Selectam cantitatea produsului
        WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity-2")));

        quantity.clear();
        quantity.sendKeys("2");

        Assert.assertEquals(quantity.getAttribute("value"), "2", "Cantitatea trebuie sa fie 2");

        // 3. Adaugam produsul in cos
        WebElement addToCart = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("[data-testid='add-to-cart-2']")));

        js.executeScript("arguments[0].click();", addToCart);

        // 4. Deschidem cosul
        WebElement cartButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("ecom-cart-button")));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", cartButton);

        js.executeScript("arguments[0].click();", cartButton);

        // 5. Continuam spre checkout
        WebElement proceedButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("ecom-proceed-to-buy")));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", proceedButton);

        js.executeScript("arguments[0].click();", proceedButton);

        // 6. Completam datele de livrare
        completeField(wait, "ecom-address-name", "Ion Popescu");

        completeField(wait, "ecom-address-street", "Strada Florilor 10");

        completeField(wait, "ecom-address-city", "Timisoara");

        completeField(wait, "ecom-address-state", "Timis");

        completeField(wait, "ecom-address-zip", "300001");

        // 7. Verificam toate campurile inainte de salvare
        Assert.assertEquals(getDriver().findElement(By.id("ecom-address-name")).getAttribute("value"), "Ion Popescu");

        Assert.assertEquals(getDriver().findElement(By.id("ecom-address-street")).getAttribute("value"), "Strada Florilor 10");

        Assert.assertEquals(getDriver().findElement(By.id("ecom-address-city")).getAttribute("value"), "Timisoara");

        Assert.assertEquals(getDriver().findElement(By.id("ecom-address-state")).getAttribute("value"), "Timis");

        Assert.assertEquals(getDriver().findElement(By.id("ecom-address-zip")).getAttribute("value"), "300001");

        // 8. Salvam adresa
        WebElement saveAddress = wait.until(ExpectedConditions.elementToBeClickable(By.id("ecom-save-address")));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", saveAddress);
        saveAddress.click();

        // Daca apare o alerta, o citim si oprim testul cu mesaj clar
        try {
            WebDriverWait alertWait = new WebDriverWait(
                    getDriver(),
                    Duration.ofSeconds(2)
            );

            Alert alert = alertWait.until(
                    ExpectedConditions.alertIsPresent()
            );

            String alertMessage = alert.getText();
            alert.accept();

            Assert.fail(
                    "Pagina a respins adresa: " + alertMessage
            );

        } catch (org.openqa.selenium.TimeoutException ignored) {
            // Nu a aparut nicio alerta; continuam testul.
        }

        // 9. Completam datele de plata
        completeField(wait, "ecom-card-number", "4111111111111111");

        completeField(wait, "ecom-expiry", "12/30");

        completeField(wait, "ecom-cvv", "123");

        // 10. Plasam comanda
        WebElement buyNow = wait.until(ExpectedConditions.elementToBeClickable(By.id("ecom-buy-now")));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", buyNow);
        buyNow.click();

        // 11. Verificam confirmarea comenzii
        WebElement orderSuccess = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("ecom-order-success")));

        Assert.assertTrue(orderSuccess.isDisplayed(),
                "Confirmarea comenzii trebuie sa fie afisata");
    }

    private void completeField(
            WebDriverWait wait,
            String elementId,
            String value
    ) {

        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));

        field.sendKeys(value);

        wait.until(driver -> value.equals(field.getAttribute("value")));

        Assert.assertEquals(field.getAttribute("value"), value, "Campul " + elementId + " nu contine valoarea asteptata");
    }
}
