package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EcommerceTest {

    @Test
    public void metodaTest() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.qapractice.com/practice-ecommerece-website");
        driver.manage().window().maximize();


        String cantitate = "2";

        String nume = "Ion Popescu";
        String strada = "Strada Principala 10";
        String oras = "Timisoara";
        String judet = "Timis";
        String codPostal = "300001";

        String numarCard = "4111111111111111";
        String expirare = "12/30";
        String cvv = "123";

        // 1. CANTITATE - WIRELESS MOUSE
        WebElement quantity = driver.findElement(By.id("quantity-2"));
        quantity.clear();
        quantity.sendKeys(cantitate);

        // 2. ADD TO CART
        WebElement addToCart = driver.findElement(By.xpath("//button[@data-testid='add-to-cart-2']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addToCart);

        // 3. DESCHIDEM COSUL
        WebElement cartButton = driver.findElement(By.id("ecom-cart-button"));

        Assert.assertTrue(cartButton.isDisplayed());
        cartButton.click();

        // 4. PROCEED TO BUY
        WebElement proceedToBuy = driver.findElement(By.id("ecom-proceed-to-buy"));
        js.executeScript("arguments[0].click();", proceedToBuy);


        // 5. SHIPPING ADDRESS
        WebElement name = driver.findElement(By.id("ecom-address-name"));
        name.sendKeys(nume);

        WebElement street = driver.findElement(By.id("ecom-address-street"));
        street.sendKeys(strada);

        WebElement city = driver.findElement(By.id("ecom-address-city"));
        city.sendKeys(oras);

        WebElement state = driver.findElement(By.id("ecom-address-state"));
        state.sendKeys(judet);

        WebElement zip = driver.findElement(By.id("ecom-address-zip"));
        zip.sendKeys(codPostal);


        Assert.assertEquals(name.getAttribute("value"), nume);

        WebElement saveAddress = driver.findElement(By.id("ecom-save-address"));
        saveAddress.click();

        // 6. PAYMENT DETAILS
        WebElement cardNumber = driver.findElement(By.id("ecom-card-number"));
        cardNumber.sendKeys(numarCard);

        WebElement expiry = driver.findElement(By.id("ecom-expiry"));
        expiry.sendKeys(expirare);

        WebElement cvvField = driver.findElement(By.id("ecom-cvv"));
        cvvField.sendKeys(cvv);

        Assert.assertEquals(cardNumber.getAttribute("value"), numarCard);

        // 7. BUY NOW
        WebElement buyNow = driver.findElement(By.id("ecom-buy-now"));

        Assert.assertTrue(buyNow.isDisplayed());

        buyNow.click();

        // 8. VERIFICAM COMANDA FINALIZATA
        WebElement orderSuccess = driver.findElement(By.id("ecom-order-success"));

        Assert.assertEquals(orderSuccess.getText(), "Order Successful!");

        driver.quit();
    }
}