package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XPathPracticeTest7 extends Test_Base_Page {

    @Test
    public void selectImageByAltTest() {

        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        XPathPracticePage xpathPracticePage = new XPathPracticePage(getDriver());

        xpathPracticePage.clickSelectImageByAlt();

        String xpathImage = "//img[@alt='Red Sneakers']";

        xpathPracticePage.enterXPath(xpathImage);

        xpathPracticePage.clickSubmit();

        Assert.assertTrue(xpathPracticePage.isSuccessMessageDisplayed(), "Verificarea exercitiului Select Image by Alt nu a fost confirmata.");

        System.out.println("Testul 7 a trecut!");
    }
}