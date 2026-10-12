package Pages;

import HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


// Clasa reprezintă pagina de Registration.
public class RegistrationPage {

    WebDriver driver;
    ElementsMethods elementsMethods; // Folosim metodele reutilizabile pentru elementele paginii.


    // Constructorul primește driver-ul din test.
    public RegistrationPage(WebDriver driver) {

        this.driver = driver;

        // Creăm obiectul ElementsMethods.
        this.elementsMethods = new ElementsMethods(driver);

        // Inițializăm elementele @FindBy.
        PageFactory.initElements(driver, this);
    }


    // Link-ul Register now de pe pagina Login.
    @FindBy(xpath = "//a[@id='login-register']")
    WebElement registerNow;


    // Câmpul Email.
    @FindBy(xpath = "//input[@id='register-email']")
    WebElement emailField;


    // Primul câmp Password.
    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement passwordField;


    // Al doilea câmp Password pentru confirmare.
    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement confirmPasswordField;


    // Butonul Register.
    @FindBy(xpath = "//button[@id='register-submit']")
    WebElement registerButton;


    // Mesajul afișat după înregistrarea cu succes.
    @FindBy(xpath = "//*[@data-testid='register-success']")
    WebElement successMessage;


    // Apăsăm Register now.
    public void clickRegisterNow() {

        elementsMethods.clickOnElement(registerNow);
    }


    // Introducem email-ul.
    public void enterEmail(String email) {

        elementsMethods.enterText(emailField, email);
    }


    // Introducem parola.
    public void enterPassword(String password) {

        elementsMethods.enterText(passwordField, password);
    }


    // Introducem parola pentru confirmare.
    public void enterConfirmPassword(String password) {

        elementsMethods.enterText(confirmPasswordField, password);
    }


    // Verificăm dacă butonul Register este afișat.
    public boolean isRegisterDisplayed() {

        return registerButton.isDisplayed();
    }


    // Verificăm dacă butonul Register poate fi apăsat.
    public boolean isRegisterEnabled() {

        return registerButton.isEnabled();
    }


    // Apăsăm butonul Register.
    public void clickRegister() {

        elementsMethods.clickOnElement(registerButton);
    }


    // Returnăm mesajul de succes.
    public String getSuccessMessage() {

        return successMessage.getText();
    }


    // Returnăm valoarea introdusă în câmpul Email.
    public String getEmailValue() {

        return emailField.getAttribute("value");
    }
}
