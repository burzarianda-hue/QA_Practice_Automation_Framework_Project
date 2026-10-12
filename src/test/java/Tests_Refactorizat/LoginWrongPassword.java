package Tests_Refactorizat;

import HelperMethods.ScreenshotMethods;
import ObjectData.LoginObject;
import Pages.LoginPage;
import Shared_Data.Test_Base_Page;
import XmlReader.XmlDataLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginWrongPassword extends Test_Base_Page {

    @Test
    public void metodaTest() {

        // Citim datele din XML.
        Map<String, LoginObject> loginObjectMap = XmlDataLoader.loadData("src/test/resources/LoginNegativeData.xml", LoginObject.class);

        // Preluam datele pentru testul negativ.
        LoginObject data = loginObjectMap.get("dataSet_1");

        Assert.assertNotNull(data, "Datele pentru Login negativ nu au fost citite din XML!");

        // Deschidem pagina de Login.
        getDriver().get("https://www.qapractice.com/practice-login-form");

        // Cream obiectul LoginPage.
        LoginPage loginPage = new LoginPage(getDriver());

        // Introducem emailul din XML.
        loginPage.enterEmail(data.getEmail());

        Assert.assertEquals(loginPage.getEmailValue(), data.getEmail());

        // Introducem parola gresita din XML.
        loginPage.enterPassword(data.getPassword());

        Assert.assertEquals(loginPage.getPasswordValue(), data.getPassword());

        // Verificam butonul Sign in.
        Assert.assertTrue(loginPage.isSignInDisplayed());
        Assert.assertTrue(loginPage.isSignInEnabled());

        // Apasam Sign in.
        loginPage.clickSignIn();

        // Verificam mesajul de eroare.
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email id and password");


        // Capturam pagina dupa afisarea mesajului de eroare.
        ScreenshotMethods.captureScreenshot(getDriver(), "LoginWrongPassword");
    }


}
