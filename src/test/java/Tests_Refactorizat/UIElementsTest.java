package Tests_Refactorizat;

import Pages.UIElementsPage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;


// Testul UI Elements refactorizat.
public class UIElementsTest extends Test_Base_Page {

    @Test
    public void metodaTest() {

        // Deschidem pagina UI Elements.
        getDriver().get("https://www.qapractice.com/practice-different-ui-elements");


        // Creăm obiectul UIElementsPage.
        UIElementsPage uiElementsPage = new UIElementsPage(getDriver());


        // 1. TEXT FIELD

        // Datele de test.
        String textFieldData = "Test QA";

        // Introducem textul.
        uiElementsPage.enterTextField(textFieldData);

        // Verificăm textul introdus.
        Assert.assertEquals(uiElementsPage.getTextFieldValue(), textFieldData);


        // 2. TEXT AREA

        // Datele de test.
        String textAreaData = "Acesta este un test pentru Text Area.";

        uiElementsPage.enterTextArea(textAreaData);

        // Verificăm textul introdus.
        Assert.assertEquals(uiElementsPage.getTextAreaValue(), textAreaData);


        // 3. BUTTON

        // Verificăm dacă butonul este afișat.
        Assert.assertTrue(uiElementsPage.isButtonDisplayed());

        // Apăsăm butonul.
        uiElementsPage.clickButton();


        // 4. CHECKBOX

        // Apăsăm checkbox-ul.
        uiElementsPage.clickCheckbox();

        // Verificăm dacă checkbox-ul este selectat.
        Assert.assertTrue(uiElementsPage.isCheckboxSelected());


        // 5. RADIO BUTTON

        // Selectăm Radio 1.
        uiElementsPage.clickRadioButton();

        // Verificăm dacă Radio 1 este selectat.
        Assert.assertTrue(uiElementsPage.isRadioButtonSelected());


        // 6. DROPDOWN

        // Selectăm Canada.
        uiElementsPage.selectDropdown("Canada");

        // Verificăm dacă Canada este selectată.
        Assert.assertEquals(uiElementsPage.getSelectedDropdownValue(), "Canada");

        // 7. MULTI DROPDOWN

        // Selectăm Option A.
        uiElementsPage.selectMultiOptionA();

        // Selectăm Option B.
        uiElementsPage.selectMultiOptionB();

        // Verificăm Option A.
        Assert.assertTrue(uiElementsPage.isOptionASelected());

        // Verificăm Option B.
        Assert.assertTrue(uiElementsPage.isOptionBSelected());
    }
}