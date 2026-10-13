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

        xpathPracticePage.clickSelectRadioByValue();

        String xpathRadio = "//input[@value='express']";

        xpathPracticePage.enterXPath(xpathRadio);

        xpathPracticePage.clickSubmit();

        Assert.assertTrue(xpathPracticePage.isSuccessMessageDisplayed(), "Verificarea exercitiului Select Radio by Value nu a fost confirmata.");
    }
}