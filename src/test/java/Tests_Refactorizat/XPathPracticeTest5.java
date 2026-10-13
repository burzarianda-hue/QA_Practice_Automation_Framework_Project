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

        xpathPracticePage.clickSelectCheckbox();

        String xpathCheckbox = "//input[@id='terms']";

        xpathPracticePage.enterXPath(xpathCheckbox);

        xpathPracticePage.clickSubmit();

        Assert.assertTrue(xpathPracticePage.isSuccessMessageDisplayed(), "Verificarea exercitiului Select Checkbox nu a fost confirmata.");
    }
}