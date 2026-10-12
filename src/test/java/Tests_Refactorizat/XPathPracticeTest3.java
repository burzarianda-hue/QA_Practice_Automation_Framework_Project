package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

// Testul pentru exercițiul 3 din XPath Guide.
public class XPathPracticeTest3 extends Test_Base_Page {

    @Test
    public void selectByExactTextTest() {

        // Deschidem pagina XPath Guide.
        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        // Creăm obiectul XPathPracticePage.
        XPathPracticePage xpathGuidePage = new XPathPracticePage(getDriver());

        // Selectăm exercițiul Select by exact text.
        xpathGuidePage.clickSelectByExactText();

        // XPath-ul pentru exercițiul 3.
        String xpathForgotPassword = "//a[text()='Forgot password?']";

        // Introducem XPath-ul.
        xpathGuidePage.enterXPath(xpathForgotPassword);

        // Apăsăm Submit.
        xpathGuidePage.clickSubmit();

        // Verificăm dacă apare mesajul verde de succes.
        Assert.assertTrue(xpathGuidePage.isSuccessMessageDisplayed());
    }
}
