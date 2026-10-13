package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XPathPracticeTest10 extends Test_Base_Page {

    @Test
    public void selectAByItsIdTest() {

        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        XPathPracticePage xpathPracticePage = new XPathPracticePage(getDriver());

        xpathPracticePage.clickSelectAById();

        xpathPracticePage.enterXPath("//a[@id='cart-link']");

        xpathPracticePage.clickSubmit();

        Assert.assertTrue(xpathPracticePage.isExercise10Active(), "Verificarea exercitiului 10 nu a fost confirmata.");
    }
}