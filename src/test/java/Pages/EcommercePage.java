package Pages;

import HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


// Clasa reprezintă pagina de E-commerce.
public class EcommercePage {

    WebDriver driver;

    // Folosim metodele reutilizabile pentru elementele paginii.
    ElementsMethods elementsMethods;


    // Constructorul primește driver-ul din test.
    public EcommercePage(WebDriver driver) {

        this.driver = driver;

        // Creăm obiectul ElementsMethods.
        this.elementsMethods = new ElementsMethods(driver);

        // Inițializăm elementele @FindBy.
        PageFactory.initElements(driver, this);
    }


    // Câmpul Quantity pentru Wireless Mouse.
    @FindBy(id = "quantity-2")
    WebElement quantity;


    // Butonul Add to Cart.
    @FindBy(xpath = "//button[@data-testid='add-to-cart-2']")
    WebElement addToCart;


    // Butonul Cart.
    @FindBy(id = "ecom-cart-button")
    WebElement cartButton;


    // Butonul Proceed to Buy.
    @FindBy(id = "ecom-proceed-to-buy")
    WebElement proceedToBuy;


    // Câmpul Full Name.
    @FindBy(id = "ecom-address-name")
    WebElement name;


    // Câmpul Street Address.
    @FindBy(id = "ecom-address-street")
    WebElement street;


    // Câmpul City.
    @FindBy(id = "ecom-address-city")
    WebElement city;


    // Câmpul State.
    @FindBy(id = "ecom-address-state")
    WebElement state;


    // Câmpul Zipcode.
    @FindBy(id = "ecom-address-zip")
    WebElement zip;


    // Butonul Save Address.
    @FindBy(id = "ecom-save-address")
    WebElement saveAddress;


    // Câmpul Card Number.
    @FindBy(id = "ecom-card-number")
    WebElement cardNumber;


    // Câmpul Expiry.
    @FindBy(id = "ecom-expiry")
    WebElement expiry;


    // Câmpul CVV.
    @FindBy(id = "ecom-cvv")
    WebElement cvv;


    // Butonul Buy Now.
    @FindBy(id = "ecom-buy-now")
    WebElement buyNow;


    // Mesajul Order Successful.
    @FindBy(id = "ecom-order-success")
    WebElement orderSuccess;


    // Introducem cantitatea.
    public void enterQuantity(String quantityValue) {

        elementsMethods.enterText(quantity, quantityValue);
    }


    // Apăsăm Add to Cart.
    public void clickAddToCart() {

        elementsMethods.clickOnElement(addToCart);
    }


    // Verificăm dacă butonul Cart este afișat.
    public boolean isCartDisplayed() {

        return cartButton.isDisplayed();
    }


    // Apăsăm Cart.
    public void clickCart() {

        elementsMethods.clickOnElement(cartButton);
    }


    // Apăsăm Proceed to Buy.
    public void clickProceedToBuy() {

        elementsMethods.clickOnElement(proceedToBuy);
    }


    // Introducem numele.
    public void enterName(String nameValue) {

        elementsMethods.enterText(name, nameValue);
    }


    // Introducem strada.
    public void enterStreet(String streetValue) {

        elementsMethods.enterText(street, streetValue);
    }


    // Introducem orașul.
    public void enterCity(String cityValue) {

        elementsMethods.enterText(city, cityValue);
    }


    // Introducem județul.
    public void enterState(String stateValue) {

        elementsMethods.enterText(state, stateValue);
    }


    // Introducem codul poștal.
    public void enterZip(String zipValue) {

        elementsMethods.enterText(zip, zipValue);
    }


    // Verificăm numele introdus.
    public String getNameValue() {

        return name.getAttribute("value");
    }


    // Salvăm adresa.
    public void clickSaveAddress() {

        elementsMethods.clickOnElement(saveAddress);
    }


    // Introducem numărul cardului.
    public void enterCardNumber(String cardValue) {

        elementsMethods.enterText(cardNumber, cardValue);
    }


    // Introducem data expirării.
    public void enterExpiry(String expiryValue) {

        elementsMethods.enterText(expiry, expiryValue);
    }


    // Introducem CVV-ul.
    public void enterCvv(String cvvValue) {

        elementsMethods.enterText(cvv, cvvValue);
    }


    // Verificăm numărul cardului.
    public String getCardNumberValue() {

        return cardNumber.getAttribute("value");
    }


    // Verificăm dacă butonul Buy Now este afișat.
    public boolean isBuyNowDisplayed() {

        return buyNow.isDisplayed();
    }


    // Apăsăm Buy Now.
    public void clickBuyNow() {

        elementsMethods.clickOnElement(buyNow);
    }


    // Returnăm mesajul final.
    public String getOrderSuccessMessage() {

        return orderSuccess.getText();
    }
}
