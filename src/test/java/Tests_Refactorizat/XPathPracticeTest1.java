package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;


// Testul pentru exercițiul 1 din XPath Guide.
public class XPathPracticeTest1 extends Test_Base_Page {

    @Test
    public void selectByIdTest() {

        // Deschidem pagina XPath Guide.
        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        // Creăm obiectul XPathPracticePage.
        XPathPracticePage xpathGuidePage = new XPathPracticePage(getDriver());

        // Selectăm exercițiul Select by ID.
        xpathGuidePage.clickSelectById();

        // Introducem XPath-ul corect pentru Username.
        String xpathUsername = "//input[@id='username']";

        xpathGuidePage.enterXPath(xpathUsername);

        // Apăsăm Submit.
        xpathGuidePage.clickSubmit();

        Assert.assertTrue(xpathGuidePage.isSuccessMessageDisplayed());

    }
}