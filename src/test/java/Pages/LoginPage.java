package Pages;

import HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    ElementsMethods elementsMethods;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='login-email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='login-password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@id='login-submit']")
    WebElement signInButton;

    @FindBy(xpath = "//*[@data-testid='login-success']")
    WebElement successMessage;

    @FindBy(id = "login-error")
    WebElement errorMessage;

    public void enterEmail(String email) {

        elementsMethods.enterText(emailField, email);
    }

    public void enterPassword(String password) {

        elementsMethods.enterText(passwordField, password);
    }


    public String getEmailValue() {

        return emailField.getAttribute("value");
    }


    public String getPasswordValue() {

        return passwordField.getAttribute("value");
    }


    public boolean isSignInDisplayed() {

        return signInButton.isDisplayed();
    }


    public boolean isSignInEnabled() {

        return signInButton.isEnabled();
    }


    public void clickSignIn() {

        elementsMethods.clickOnElement(signInButton);
    }


    public String getSuccessMessage() {

        return successMessage.getText();
    }

    public String getErrorMessage() {

        return errorMessage.getText();
    }
}
