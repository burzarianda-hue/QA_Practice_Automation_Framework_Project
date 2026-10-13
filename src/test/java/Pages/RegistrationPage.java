package Pages;

import HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegistrationPage {

    WebDriver driver;
    ElementsMethods elementsMethods;


    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='login-register']")
    WebElement registerNow;

    @FindBy(xpath = "//input[@id='register-email']")
    WebElement emailField;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement passwordField;


    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement confirmPasswordField;


    @FindBy(xpath = "//button[@id='register-submit']")
    WebElement registerButton;


    @FindBy(xpath = "//*[@data-testid='register-success']")
    WebElement successMessage;


    public void clickRegisterNow() {

        elementsMethods.clickOnElement(registerNow);
    }

    public void enterEmail(String email) {

        elementsMethods.enterText(emailField, email);
    }

    public void enterPassword(String password) {

        elementsMethods.enterText(passwordField, password);
    }

    public void enterConfirmPassword(String password) {

        elementsMethods.enterText(confirmPasswordField, password);
    }

    public boolean isRegisterDisplayed() {

        return registerButton.isDisplayed();
    }

    public boolean isRegisterEnabled() {

        return registerButton.isEnabled();
    }

    public void clickRegister() {

        elementsMethods.clickOnElement(registerButton);
    }

    public String getSuccessMessage() {

        return successMessage.getText();
    }

    public String getEmailValue() {

        return emailField.getAttribute("value");
    }
}
