package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XPathPracticeTest9 extends Test_Base_Page {

    @Test
    public void selectLinkByHrefTest() {

        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        XPathPracticePage xpathPracticePage = new XPathPracticePage(getDriver());

        xpathPracticePage.clickSelectLinkByHref();

        xpathPracticePage.enterXPath("//a[@href='/privacy']");

        xpathPracticePage.clickSubmit();

        Assert.assertTrue(xpathPracticePage.isExercise9Active(), "Verificarea exercitiului 9 nu a fost confirmata.");
    }
}
