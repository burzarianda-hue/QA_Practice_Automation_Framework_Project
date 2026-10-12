package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

// Testul pentru exercițiul 2 din XPath Guide.
public class XPathPracticeTest2 extends Test_Base_Page {

    @Test
    public void selectByClassTest() {

        // Deschidem pagina XPath Guide.
        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        // Creăm obiectul XPathPracticePage.
        XPathPracticePage xpathGuidePage = new XPathPracticePage(getDriver());

        // Selectăm exercițiul Select by Class.
        xpathGuidePage.clickSelectByClass();

        // XPath-ul pentru exercițiul Select by Class.
        String xpathButton = "//button[@class='btn primary']";

        // Introducem XPath-ul.
        xpathGuidePage.enterXPath(xpathButton);

        // Apăsăm Submit.
        xpathGuidePage.clickSubmit();

        // Verificăm dacă apare mesajul verde de succes.
        Assert.assertTrue(xpathGuidePage.isSuccessMessageDisplayed());
    }
}

