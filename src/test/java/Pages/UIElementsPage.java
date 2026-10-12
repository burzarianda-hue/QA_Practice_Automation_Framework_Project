package Pages;

import HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


// Clasa reprezintă pagina UI Elements.
public class UIElementsPage {

    WebDriver driver;

    // Folosim metodele reutilizabile pentru elementele paginii.
    ElementsMethods elementsMethods;


    // Constructorul primește driver-ul din test.
    public UIElementsPage(WebDriver driver) {

        this.driver = driver;

        // Creăm obiectul ElementsMethods.
        this.elementsMethods = new ElementsMethods(driver);

        // Inițializăm elementele @FindBy.
        PageFactory.initElements(driver, this);
    }


    // 1. TEXT FIELD
    @FindBy(id = "textField")
    WebElement textField;


    // 2. TEXT AREA
    @FindBy(id = "textArea")
    WebElement textArea;


    // 3. BUTTON
    @FindBy(id = "ui-click-button")
    WebElement button;


    // 4. CHECKBOX
    @FindBy(id = "ui-single-checkbox")
    WebElement checkbox;


    // 5. RADIO BUTTON
    @FindBy(id = "ui-radio-Radio 1")
    WebElement radioButton;


    // 6. DROPDOWN
    @FindBy(id = "singleDropdown")
    WebElement dropdown;


    // 7. MULTI DROPDOWN
    @FindBy(id = "multiDropdown")
    WebElement multiDropdown;


    // Introducem text în Text Field.
    public void enterTextField(String text) {

        elementsMethods.enterText(textField, text);
    }


    // Returnăm valoarea din Text Field.
    public String getTextFieldValue() {

        return textField.getAttribute("value");
    }


    // Introducem text în Text Area.
    public void enterTextArea(String text) {

        elementsMethods.enterText(textArea, text);
    }


    // Returnăm valoarea din Text Area.
    public String getTextAreaValue() {

        return textArea.getAttribute("value");
    }


    // Verificăm dacă butonul este afișat.
    public boolean isButtonDisplayed() {

        return button.isDisplayed();
    }


    // Apăsăm butonul.
    public void clickButton() {

        elementsMethods.clickOnElement(button);
    }


    // Apăsăm checkbox-ul.
    public void clickCheckbox() {

        elementsMethods.clickOnElement(checkbox);
    }


    // Verificăm dacă checkbox-ul este selectat.
    public boolean isCheckboxSelected() {

        return checkbox.isSelected();
    }


    // Selectăm Radio 1.
    public void clickRadioButton() {

        elementsMethods.clickOnElement(radioButton);
    }


    // Verificăm dacă Radio 1 este selectat.
    public boolean isRadioButtonSelected() {

        return radioButton.isSelected();
    }


    // Selectăm o opțiune din dropdown după text.
    public void selectDropdown(String text) {

        elementsMethods.selectByText(dropdown, text);
    }


    // Returnăm opțiunea selectată din dropdown.
    public String getSelectedDropdownValue() {

        return dropdown.getAttribute("value");
    }


    // Selectăm Option A din Multi Dropdown.
    public void selectMultiOptionA() {

        elementsMethods.selectByText(multiDropdown, "Option A");
    }


    // Selectăm Option B din Multi Dropdown.
    public void selectMultiOptionB() {

        elementsMethods.selectByText(multiDropdown, "Option B");
    }


    // Verificăm dacă Option A este selectată.
    public boolean isOptionASelected() {

        Select select = new Select(multiDropdown);
        return select.getOptions().get(0).isSelected();
    }


    // Verificăm dacă Option B este selectată.
    public boolean isOptionBSelected() {

        Select select = new Select(multiDropdown);
        return select.getOptions().get(1).isSelected();
    }
}