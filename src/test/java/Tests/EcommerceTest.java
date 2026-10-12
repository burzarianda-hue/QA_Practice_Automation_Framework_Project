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

        // Deschidem browserul
        WebDriver driver = new ChromeDriver();

        // Deschidem pagina de E-commerce
        driver.get("https://www.qapractice.com/practice-ecommerece-website");

        // Maximizam fereastra
        driver.manage().window().maximize();

        // DATELE DE TEST - STRING

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

        // Gasim campul Quantity pentru produsul 2
        WebElement quantity = driver.findElement(By.id("quantity-2"));
        quantity.clear(); // Stergem valoarea existenta
        quantity.sendKeys(cantitate); // Introducem cantitatea


       // 2. ADD TO CART
        //Gasim butonul Add to Cart pentru Wireless Mouse
        WebElement addToCart = driver.findElement(By.xpath("//button[@data-testid='add-to-cart-2']"));
        //Apasam butonul Add to Cart folosind JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addToCart);

        // 3. DESCHIDEM COSUL
        // Gasim butonul Cart
        WebElement cartButton = driver.findElement(By.id("ecom-cart-button"));

        // Verificam ca butonul este vizibil
        Assert.assertTrue(cartButton.isDisplayed());
        // Apasam Cart
        cartButton.click();

        // 4. PROCEED TO BUY

        //Gasim butonul Proceed to Buy
        WebElement proceedToBuy = driver.findElement(By.id("ecom-proceed-to-buy"));
        //Apasam butonul Proceed to Buy folosind JavaScript
        js.executeScript("arguments[0].click();", proceedToBuy);


        // 5. SHIPPING ADDRESS

        // Gasim campul Full Name
        WebElement name = driver.findElement(By.id("ecom-address-name"));
        name.sendKeys(nume);// Introducem numele

        // Gasim campul Street Address
        WebElement street = driver.findElement(By.id("ecom-address-street"));
        street.sendKeys(strada);// Introducem strada

        // Gasim campul City
        WebElement city = driver.findElement(By.id("ecom-address-city"));
        city.sendKeys(oras);// Introducem orasul

        // Gasim campul State
        WebElement state = driver.findElement(By.id("ecom-address-state"));
        state.sendKeys(judet);// Introducem judetul

        // Gasim campul Zipcode
        WebElement zip = driver.findElement(By.id("ecom-address-zip"));
        zip.sendKeys(codPostal);// Introducem codul postal

        // Verificam numele introdus
        Assert.assertEquals(name.getAttribute("value"), nume);

        // Salvam adresa si continuam catre plata
        WebElement saveAddress = driver.findElement(By.id("ecom-save-address"));
        saveAddress.click();// Apasam butonul



        // 6. PAYMENT DETAILS

        // Gasim campul Card Number
        WebElement cardNumber = driver.findElement(By.id("ecom-card-number"));
        cardNumber.sendKeys(numarCard); // Introducem numarul cardului

        // Gasim campul Expiry
        WebElement expiry = driver.findElement(By.id("ecom-expiry"));
        expiry.sendKeys(expirare);// Introducem data expirarii

        // Gasim campul CVV
        WebElement cvvField = driver.findElement(By.id("ecom-cvv"));
        cvvField.sendKeys(cvv);// Introducem CVV-ul

        // Verificam numarul cardului introdus
        Assert.assertEquals(cardNumber.getAttribute("value"), numarCard);


        // 7. BUY NOW

        // Gasim butonul Buy Now
        WebElement buyNow = driver.findElement(By.id("ecom-buy-now"));

        // Verificam ca butonul este vizibil
        Assert.assertTrue(buyNow.isDisplayed());

        // Apasam Buy Now
        buyNow.click();

        // 8. VERIFICAM COMANDA FINALIZATA

        // Gasim mesajul Order Successful
        WebElement orderSuccess = driver.findElement(By.id("ecom-order-success"));

        // Verificam mesajul final
        Assert.assertEquals(orderSuccess.getText(), "Order Successful!");

        // Inchidem browserul
        driver.quit();
    }
}


