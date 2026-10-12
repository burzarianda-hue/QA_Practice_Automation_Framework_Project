package Tests_Refactorizat;

import ObjectData.LoginObject;
import Pages.LoginPage;
import Shared_Data.Test_Base_Page;
import XmlReader.XmlDataLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

// Clasa conține testul de Login refactorizat.
public class LoginTest extends Test_Base_Page {
    private Map<String, LoginObject> loginObjectMap;

    @Test
    public void metodaTest() {

        // Citim datele de test din fisierul XML.
        loginObjectMap = XmlDataLoader.loadData("src/test/resources/LoginData.xml", LoginObject.class);
        LoginObject data = loginObjectMap.get("dataSet_1");  // Preluam datele din setul dataSet_1.

        // Verificam daca datele au fost citite.
        Assert.assertNotNull(data, "Datele de Login nu au fost citite din XML!");

        // Deschidem pagina de Login.
        getDriver().get("https://www.qapractice.com/practice-login-form");

        // Cream obiectul LoginPage.
        LoginPage loginPage = new LoginPage(getDriver());

        // Introducem emailul citit din XML.
        loginPage.enterEmail(data.getEmail());

        // Verificam emailul introdus.
        Assert.assertEquals(loginPage.getEmailValue(), data.getEmail());

        // Introducem parola citita din XML.
        loginPage.enterPassword(data.getPassword());

        // Verificam parola introdusa.
        Assert.assertEquals(loginPage.getPasswordValue(), data.getPassword());

        // Verificam daca butonul Sign in este afisat.
        Assert.assertTrue(loginPage.isSignInDisplayed());

        // Verificam daca butonul Sign in poate fi apasat.
        Assert.assertTrue(loginPage.isSignInEnabled());

        // Apasam butonul Sign in.
        loginPage.clickSignIn();

        // Verificam mesajul afisat dupa Login.
        Assert.assertEquals(loginPage.getSuccessMessage(), "Login Successful! Welcome to Premium Banking.");
    }

}
