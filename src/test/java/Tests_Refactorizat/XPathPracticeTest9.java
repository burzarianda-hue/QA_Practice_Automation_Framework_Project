package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XPathPracticeTest9 extends Test_Base_Page {

    @Test
    public void selectLinkByHrefTest() {

        // Deschidem pagina XPath Guide.
        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        // Cream obiectul pentru pagina XPath Practice.
        XPathPracticePage xpathPracticePage =
                new XPathPracticePage(getDriver());

        // Selectam exercitiul 9.
        xpathPracticePage.clickSelectLinkByHref();

        // Introducem XPath-ul corect pentru linkul Privacy.
        xpathPracticePage.enterXPath("//a[@href='/privacy']");

        // Apasam Submit.
        xpathPracticePage.clickSubmit();

        // Verificam daca exercitiul 9 este rezolvat.
        Assert.assertTrue(xpathPracticePage.isExercise9Active(), "Exercitiul 9 a fost verificat cu succes.");
    }
}