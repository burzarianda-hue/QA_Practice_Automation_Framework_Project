package Tests_Refactorizat;

import Pages.XPathPracticePage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

// Testul pentru exercitiul 8 din XPath Guide.
public class XPathPracticeTest8 extends Test_Base_Page {

    @Test
    public void selectHeadingByTagAndTextTest() {

        // Deschidem pagina XPath Guide.
        getDriver().get("https://www.qapractice.com/SeleniumXPathGuide");

        // Cream obiectul paginii.
        XPathPracticePage xpathPracticePage = new XPathPracticePage(getDriver());

        // Selectam exercitiul 8.
        xpathPracticePage.clickSelectHeadingByText();

        // Introducem XPath-ul cerut.
        xpathPracticePage.enterXPath("//h2[text()='Featured Products']");

        // Apasam Submit.
        xpathPracticePage.clickSubmit();

        // Verificam daca site-ul afiseaza mesajul de succes.
        Assert.assertTrue(xpathPracticePage.isSuccessMessageDisplayed(), "Mesajul de succes nu este afisa");
    }
}