package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

// Testul pentru exercițiul 4 din XPath Guide.
public class XPathPracticeTest4 extends Test_Base_Page {

    @Test
    public void selectByPlaceholderTest() {

        // Deschidem pagina XPath Guide.
        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        // Creăm obiectul XPathPracticePage.
        XPathPracticePage xpathGuidePage = new XPathPracticePage(getDriver());

        // Selectăm exercițiul Select by Placeholder.
        xpathGuidePage.clickSelectByPlaceholder();

        // XPath-ul pentru exercițiul 4.
        String xpathSearch = "//input[@placeholder='Search products']";

        // Introducem XPath-ul.
        xpathGuidePage.enterXPath(xpathSearch);

        // Apăsăm Submit.
        xpathGuidePage.clickSubmit();

        // Verificăm dacă apare mesajul verde de succes.
        Assert.assertTrue(xpathGuidePage.isSuccessMessageDisplayed());
    }
}

