package Pages;

import HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EcommercePage {

    WebDriver driver;
    ElementsMethods elementsMethods;


    public EcommercePage(WebDriver driver) {

        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "quantity-2")
    WebElement quantity;

    @FindBy(xpath = "//button[@data-testid='add-to-cart-2']")
    WebElement addToCart;

    @FindBy(id = "ecom-cart-button")
    WebElement cartButton;

    @FindBy(id = "ecom-proceed-to-buy")
    WebElement proceedToBuy;

    @FindBy(id = "ecom-address-name")
    WebElement name;

    @FindBy(id = "ecom-address-street")
    WebElement street;

    @FindBy(id = "ecom-address-city")
    WebElement city;

    @FindBy(id = "ecom-address-state")
    WebElement state;

    @FindBy(id = "ecom-address-zip")
    WebElement zip;

    @FindBy(id = "ecom-save-address")
    WebElement saveAddress;

    @FindBy(id = "ecom-card-number")
    WebElement cardNumber;

    @FindBy(id = "ecom-expiry")
    WebElement expiry;

    @FindBy(id = "ecom-cvv")
    WebElement cvv;

    @FindBy(id = "ecom-buy-now")
    WebElement buyNow;

    @FindBy(id = "ecom-order-success")
    WebElement orderSuccess;

    public void enterQuantity(String quantityValue) {

        elementsMethods.enterText(quantity, quantityValue);
    }

    public void clickAddToCart() {

        elementsMethods.clickOnElement(addToCart);
    }


    public boolean isCartDisplayed() {

        return cartButton.isDisplayed();
    }

    public void clickCart() {

        elementsMethods.clickOnElement(cartButton);
    }


    public void clickProceedToBuy() {

        elementsMethods.clickOnElement(proceedToBuy);
    }


    public void enterName(String nameValue) {

        elementsMethods.enterText(name, nameValue);
    }


    public void enterStreet(String streetValue) {

        elementsMethods.enterText(street, streetValue);
    }


    public void enterCity(String cityValue) {

        elementsMethods.enterText(city, cityValue);
    }


    public void enterState(String stateValue) {

        elementsMethods.enterText(state, stateValue);
    }


    public void enterZip(String zipValue) {

        elementsMethods.enterText(zip, zipValue);
    }


    public String getNameValue() {

        return name.getAttribute("value");
    }


    public void clickSaveAddress() {

        elementsMethods.clickOnElement(saveAddress);
    }


    public void enterCardNumber(String cardValue) {

        elementsMethods.enterText(cardNumber, cardValue);
    }


    public void enterExpiry(String expiryValue) {

        elementsMethods.enterText(expiry, expiryValue);
    }


    public void enterCvv(String cvvValue) {

        elementsMethods.enterText(cvv, cvvValue);
    }


    public String getCardNumberValue() {

        return cardNumber.getAttribute("value");
    }


    public boolean isBuyNowDisplayed() {

        return buyNow.isDisplayed();
    }


    public void clickBuyNow() {

        elementsMethods.clickOnElement(buyNow);
    }


    public String getOrderSuccessMessage() {

        return orderSuccess.getText();
    }
}
