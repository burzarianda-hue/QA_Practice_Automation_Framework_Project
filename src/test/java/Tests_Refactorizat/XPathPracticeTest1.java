package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XPathPracticeTest1 extends Test_Base_Page {

    @Test
    public void selectByIdTest() {

        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        XPathPracticePage xpathGuidePage =
                new XPathPracticePage(getDriver());

        xpathGuidePage.clickSelectById();

        String xpathUsername = "//input[@id='username']";

        xpathGuidePage.enterXPath(xpathUsername);

        xpathGuidePage.clickSubmit();

        Assert.assertTrue(
                xpathGuidePage.isSuccessMessageDisplayed(),
                "Verificarea exercitiului Select by ID nu a fost confirmata."
        );
    }
}