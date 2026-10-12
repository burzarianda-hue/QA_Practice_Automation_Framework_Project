package Tests_Refactorizat;

import ObjectData.RegistrationObject;
import Pages.RegistrationPage;
import Shared_Data.Test_Base_Page;
import XmlReader.XmlDataLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

// Testul de Registration refactorizat.
public class RegistrationForm extends Test_Base_Page {

    private Map<String, RegistrationObject> registrationObjectMap;

    @Test
    public void metodaTest() {

        // Citim datele din fisierul XML.
        registrationObjectMap = XmlDataLoader.loadData("src/test/resources/RegistrationData.xml", RegistrationObject.class);

        // Preluam datele din dataSet_1.
        RegistrationObject data = registrationObjectMap.get("dataSet_1");

        // Verificam daca datele au fost citite.
        Assert.assertNotNull(data, "Datele de Registration nu au fost citite din XML!");

        // Deschidem pagina de Login.
        getDriver().get("https://www.qapractice.com/practice-login-form");

        // Cream obiectul RegistrationPage.
        RegistrationPage registrationPage =
                new RegistrationPage(getDriver());

        // Apasam Register now.
        registrationPage.clickRegisterNow();

        // Introducem emailul din XML.
        registrationPage.enterEmail(data.getEmail());

        // Verificam emailul introdus.
        Assert.assertEquals(registrationPage.getEmailValue(), data.getEmail());

        // Introducem parola din XML.
        registrationPage.enterPassword(data.getPassword());

        // Confirmam parola folosind datele din XML.
        registrationPage.enterConfirmPassword(data.getConfirmPassword());

        // Verificam butonul Register.
        Assert.assertTrue(registrationPage.isRegisterDisplayed());
        Assert.assertTrue(registrationPage.isRegisterEnabled());

        // Apasam butonul Register.
        registrationPage.clickRegister();

        // Verificam mesajul de succes.
        Assert.assertEquals(registrationPage.getSuccessMessage(), "Registration Successful");
    }

}
