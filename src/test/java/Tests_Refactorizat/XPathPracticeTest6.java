package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XPathPracticeTest6 extends Test_Base_Page {

    @Test
    public void selectRadioByValueTest() {

        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        XPathPracticePage xpathPracticePage = new XPathPracticePage(getDriver());

        // Selectăm exercițiul 6
        xpathPracticePage.clickSelectRadioByValue();

        // XPath pentru butonul radio Express
        String xpathRadio = "//input[@value='express']";

        // Introducem XPath-ul
        xpathPracticePage.enterXPath(xpathRadio);

        // Apăsăm Submit
        xpathPracticePage.clickSubmit();

        // Verificăm dacă XPath-ul este corect
        Assert.assertTrue(
                xpathPracticePage.isSuccessMessageDisplayed(),
                "Test eșuat: butonul radio Express nu a fost identificat corect."
        );
    }
}

