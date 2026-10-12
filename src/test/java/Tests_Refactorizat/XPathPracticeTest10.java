package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

// Testul pentru exercitiul 10 din XPath Guide.
public class XPathPracticeTest10 extends Test_Base_Page {

    @Test
    public void selectAByItsIdTest() {

        // Deschidem pagina XPath Guide.
        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        // Cream obiectul pentru pagina XPath Practice.
        XPathPracticePage xpathPracticePage =
                new XPathPracticePage(getDriver());

        // Selectam exercitiul 10.
        xpathPracticePage.clickSelectAById();

        // Introducem XPath-ul corect pentru linkul Cart.
        xpathPracticePage.enterXPath("//a[@id='cart-link']");

        // Apasam Submit.
        xpathPracticePage.clickSubmit();

        // Verificam daca exercitiul 10 este rezolvat.
        Assert.assertTrue(xpathPracticePage.isExercise10Active(), "Exercitiul 10 a fost verificat cu succes.");
    }
}