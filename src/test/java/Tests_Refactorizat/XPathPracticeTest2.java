package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XPathPracticeTest2 extends Test_Base_Page {

    @Test
    public void selectByClassTest() {

        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        XPathPracticePage xpathGuidePage = new XPathPracticePage(getDriver());

        xpathGuidePage.clickSelectByClass();

        String xpathButton = "//button[@class='btn primary']";

        xpathGuidePage.enterXPath(xpathButton);

        xpathGuidePage.clickSubmit();

        Assert.assertTrue(xpathGuidePage.isSuccessMessageDisplayed(), "Verificarea exercitiului Select by Class nu a fost confirmata.");
    }
}