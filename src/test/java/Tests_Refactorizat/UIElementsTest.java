package Tests_Refactorizat;

import Pages.UIElementsPage;
import Shared_Data.Test_Base_Page;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UIElementsTest extends Test_Base_Page {

    @Test
    public void metodaTest() {

        getDriver().get("https://www.qapractice.com/practice-different-ui-elements");

        UIElementsPage uiElementsPage = new UIElementsPage(getDriver());

        String textFieldData = "Test QA";

        uiElementsPage.enterTextField(textFieldData);

        Assert.assertEquals(uiElementsPage.getTextFieldValue(), textFieldData, "Textul introdus in Text Field nu corespunde.");

        String textAreaData = "Acesta este un test pentru Text Area.";

        uiElementsPage.enterTextArea(textAreaData);

        Assert.assertEquals(uiElementsPage.getTextAreaValue(), textAreaData, "Textul introdus in Text Area nu corespunde.");

        Assert.assertTrue(uiElementsPage.isButtonDisplayed(), "Butonul nu este afisat.");

        uiElementsPage.clickButton();

        uiElementsPage.clickCheckbox();

        Assert.assertTrue(uiElementsPage.isCheckboxSelected(), "Checkbox-ul nu este selectat.");

        uiElementsPage.clickRadioButton();

        Assert.assertTrue(uiElementsPage.isRadioButtonSelected(), "Radio Button nu este selectat.");

        uiElementsPage.selectDropdown("Canada");

        Assert.assertEquals(uiElementsPage.getSelectedDropdownValue(), "Canada", "Valoarea selectata din Dropdown nu corespunde.");

        uiElementsPage.selectMultiOptionA();
        uiElementsPage.selectMultiOptionB();

        Assert.assertTrue(uiElementsPage.isOptionASelected(), "Option A nu este selectata.");

        Assert.assertTrue(uiElementsPage.isOptionBSelected(), "Option B nu este selectata.");
    }
}
