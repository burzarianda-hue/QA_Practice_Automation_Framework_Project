package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XPathPracticeTest7 extends Test_Base_Page {

    @Test
    public void selectImageByAltTest() {

        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        XPathPracticePage xpathPracticePage =
                new XPathPracticePage(getDriver());

        // Selectam exercitiul 7
        xpathPracticePage.clickSelectImageByAlt();

        // XPath-ul corect pentru imaginea tinta
        String xpathImage = "//img[@alt='Red Sneakers']";

        // Introducem XPath-ul
        xpathPracticePage.enterXPath(xpathImage);

        // Apasam Submit
        xpathPracticePage.clickSubmit();

        // Verificam daca exercitiul a fost rezolvat corect
        Assert.assertTrue(xpathPracticePage.isSuccessMessageDisplayed(), "Test esuat: imaginea Red Sneakers nu a fost identificata corect.");

        System.out.println("Testul 7 a trecut!");
    }
}