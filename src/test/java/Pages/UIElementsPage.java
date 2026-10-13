package Pages;

import HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class UIElementsPage {

    WebDriver driver;
    ElementsMethods elementsMethods;

    public UIElementsPage(WebDriver driver) {

        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "textField")
    WebElement textField;

    @FindBy(id = "textArea")
    WebElement textArea;

    @FindBy(id = "ui-click-button")
    WebElement button;

    @FindBy(id = "ui-single-checkbox")
    WebElement checkbox;

    @FindBy(id = "ui-radio-Radio 1")
    WebElement radioButton;

    @FindBy(id = "singleDropdown")
    WebElement dropdown;

    @FindBy(id = "multiDropdown")
    WebElement multiDropdown;

    public void enterTextField(String text) {

        elementsMethods.enterText(textField, text);
    }


    public String getTextFieldValue() {

        return textField.getAttribute("value");
    }


    public void enterTextArea(String text) {

        elementsMethods.enterText(textArea, text);
    }

    public String getTextAreaValue() {

        return textArea.getAttribute("value");
    }

    public boolean isButtonDisplayed() {

        return button.isDisplayed();
    }

    public void clickButton() {

        elementsMethods.clickOnElement(button);
    }

    public void clickCheckbox() {

        elementsMethods.clickOnElement(checkbox);
    }

    public boolean isCheckboxSelected() {

        return checkbox.isSelected();
    }

    public void clickRadioButton() {

        elementsMethods.clickOnElement(radioButton);
    }

    public boolean isRadioButtonSelected() {

        return radioButton.isSelected();
    }

    public void selectDropdown(String text) {

        elementsMethods.selectByText(dropdown, text);
    }


    public String getSelectedDropdownValue() {

        return dropdown.getAttribute("value");
    }

    public void selectMultiOptionA() {

        elementsMethods.selectByText(multiDropdown, "Option A");
    }

    public void selectMultiOptionB() {

        elementsMethods.selectByText(multiDropdown, "Option B");
    }

    public boolean isOptionASelected() {

        Select select = new Select(multiDropdown);
        return select.getOptions().get(0).isSelected();
    }

    public boolean isOptionBSelected() {

        Select select = new Select(multiDropdown);
        return select.getOptions().get(1).isSelected();
    }
}