package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XPathPracticeTest3 extends Test_Base_Page {

    @Test
    public void selectByExactTextTest() {

        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        XPathPracticePage xpathGuidePage = new XPathPracticePage(getDriver());

        xpathGuidePage.clickSelectByExactText();

        String xpathForgotPassword = "//a[text()='Forgot password?']";

        xpathGuidePage.enterXPath(xpathForgotPassword);

        xpathGuidePage.clickSubmit();

        Assert.assertTrue(xpathGuidePage.isSuccessMessageDisplayed(),
                "Verificarea exercitiului Select by Exact Text nu a fost confirmata.");
    }
}