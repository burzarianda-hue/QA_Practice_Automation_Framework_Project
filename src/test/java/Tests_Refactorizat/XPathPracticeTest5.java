package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XPathPracticeTest5 extends Test_Base_Page {

    @Test
    public void selectCheckboxTest() {

        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        XPathPracticePage xpathPracticePage = new XPathPracticePage(getDriver());

        // Selectăm exercițiul 5
        xpathPracticePage.clickSelectCheckbox();

        // XPath pentru checkbox-ul "I accept the terms"
        String xpathCheckbox = "//input[@id='terms']";

        // Introducem XPath-ul
        xpathPracticePage.enterXPath(xpathCheckbox);

        // Apăsăm Submit
        xpathPracticePage.clickSubmit();

        // Verificăm dacă apare mesajul verde de succes
        Assert.assertTrue(xpathPracticePage.isSuccessMessageDisplayed(), "Test eșuat: checkbox-ul I accept the terms nu a fost identificat corect.");
    }
}

