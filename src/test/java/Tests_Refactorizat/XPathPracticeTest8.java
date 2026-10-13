package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XPathPracticeTest8 extends Test_Base_Page {

    @Test
    public void selectHeadingByTagAndTextTest() {

        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        XPathPracticePage xpathPracticePage = new XPathPracticePage(getDriver());

        xpathPracticePage.clickSelectHeadingByText();

        xpathPracticePage.enterXPath("//h2[text()='Featured Products']");

        xpathPracticePage.clickSubmit();

        Assert.assertTrue(xpathPracticePage.isSuccessMessageDisplayed(), "Verificarea exercitiului Select Heading by Tag and Text nu a fost confirmata.");
    }
}