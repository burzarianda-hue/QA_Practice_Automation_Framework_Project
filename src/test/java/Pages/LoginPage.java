package Pages;

import HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


// Clasa reprezintă pagina de Login a aplicației QA Practice.
public class LoginPage {

    WebDriver driver;

    // Obiectul ElementsMethods conține metodele reutilizabile
    // pentru interacțiunea cu elementele.
    ElementsMethods elementsMethods;


    // Constructorul primește driver-ul din test.
    public LoginPage(WebDriver driver) {

        // Salvăm driver-ul primit în variabila clasei.
        this.driver = driver;

        // Creăm obiectul ElementsMethods și îi transmitem driver-ul.
        this.elementsMethods = new ElementsMethods(driver);

        // Inițializăm elementele care au @FindBy.
        PageFactory.initElements(driver, this);
    }


    // Câmpul pentru Email Address.
    @FindBy(xpath = "//input[@id='login-email']")
    WebElement emailField;


    // Câmpul pentru Password.
    @FindBy(xpath = "//input[@id='login-password']")
    WebElement passwordField;


    // Butonul Sign in.
    @FindBy(xpath = "//button[@id='login-submit']")
    WebElement signInButton;


    // Mesajul care apare după un login reușit.
    @FindBy(xpath = "//*[@data-testid='login-success']")
    WebElement successMessage;

    // Mesajul afișat când email-ul sau parola sunt greșite.
    @FindBy(id = "login-error")
    WebElement errorMessage;

    // Introducem adresa de email în câmp.
    public void enterEmail(String email) {

        elementsMethods.enterText(emailField, email);
    }


    // Introducem parola în câmp.
    public void enterPassword(String password) {

        elementsMethods.enterText(passwordField, password);
    }


    // Verificăm valoarea introdusă în câmpul Email.
    public String getEmailValue() {

        return emailField.getAttribute("value");
    }


    // Verificăm valoarea introdusă în câmpul Password.
    public String getPasswordValue() {

        return passwordField.getAttribute("value");
    }


    // Verificăm dacă butonul Sign in este afișat.
    public boolean isSignInDisplayed() {

        return signInButton.isDisplayed();
    }


    // Verificăm dacă butonul Sign in poate fi apăsat.
    public boolean isSignInEnabled() {

        return signInButton.isEnabled();
    }


    // Apăsăm butonul Sign in.
    public void clickSignIn() {

        elementsMethods.clickOnElement(signInButton);
    }


    // Returnăm textul mesajului afișat după login.
    public String getSuccessMessage() {

        return successMessage.getText();
    }

    // Returnăm mesajul de eroare.
    public String getErrorMessage() {

        return errorMessage.getText();
    }
}
