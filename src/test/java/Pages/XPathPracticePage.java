package Pages;

import HelperMethods.ElementsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class XPathPracticePage {

    WebDriver driver;
    ElementsMethods elementsMethods;
    WebDriverWait wait;

    public XPathPracticePage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@placeholder,'//tag')]")
    WebElement xpathInput;

    @FindBy(xpath = "//button[@data-testid='xp-submit']")
    WebElement submitButton;

    // TEST 1 - SELECT BY ID
    @FindBy(xpath = "//button[@data-testid='xp-q-select-by-id']")
    WebElement selectByIdButton;

    public void clickSelectById() {
        elementsMethods.clickOnElement(selectByIdButton);
    }

    public void enterXPath(String xpath) {
        wait.until(ExpectedConditions.visibilityOf(xpathInput));
        xpathInput.clear();
        elementsMethods.enterText(xpathInput, xpath);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        elementsMethods.clickOnElement(submitButton);
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            WebElement successMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[@data-testid='xp-status' and @data-kind='correct']")
                    )
            );

            return successMessage.isDisplayed();

        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    // TEST 2 - SELECT BY CLASS
    @FindBy(xpath = "//button[@data-testid='xp-q-select-by-class']")
    WebElement selectByClassButton;

    @FindBy(xpath = "//button[@data-testid='xp-q-select-by-class']//span[@class='xp-q-num']")
    WebElement exerciseNumberClass;

    public void clickSelectByClass() {
        elementsMethods.clickOnElement(selectByClassButton);
    }

    public String getExerciseNumberClass() {
        return exerciseNumberClass.getText();
    }

    // TEST 3 - SELECT BY EXACT TEXT
    @FindBy(xpath = "//button[@data-testid='xp-q-select-by-text']")
    WebElement selectByExactTextButton;

    @FindBy(xpath = "//button[@data-testid='xp-q-select-by-text']//span[@class='xp-q-num']")
    WebElement exerciseNumberExactText;

    public void clickSelectByExactText() {
        elementsMethods.clickOnElement(selectByExactTextButton);
    }

    public String getExerciseNumberExactText() {
        return exerciseNumberExactText.getText();
    }

    // TEST 4 - SELECT BY PLACEHOLDER
    @FindBy(xpath = "//button[@data-testid='xp-q-select-by-placeholder']")
    WebElement selectByPlaceholderButton;

    @FindBy(xpath = "//button[@data-testid='xp-q-select-by-placeholder']//span[@class='xp-q-num']")
    WebElement exerciseNumberPlaceholder;

    public void clickSelectByPlaceholder() {
        elementsMethods.clickOnElement(selectByPlaceholderButton);
    }

    public String getExerciseNumberPlaceholder() {
        return exerciseNumberPlaceholder.getText();
    }

    // TEST 5 - SELECT CHECKBOX
    @FindBy(xpath = "//button[@data-testid='xp-q-select-checkbox']")
    WebElement selectCheckboxButton;

    @FindBy(xpath = "//button[@data-testid='xp-q-select-checkbox']//span[@class='xp-q-num']")
    WebElement exerciseNumberCheckbox;

    public void clickSelectCheckbox() {
        elementsMethods.clickOnElement(selectCheckboxButton);
    }

    public String getExerciseNumberCheckbox() {
        return exerciseNumberCheckbox.getText();
    }

    // TEST 6 - SELECT RADIO BY VALUE
    @FindBy(xpath = "//button[@data-testid='xp-q-select-radio-value']")
    WebElement selectRadioByValueButton;

    @FindBy(xpath = "//button[@data-testid='xp-q-select-radio-value']//span[@class='xp-q-num']")
    WebElement exerciseNumberRadioValue;

    public void clickSelectRadioByValue() {
        wait.until(ExpectedConditions.elementToBeClickable(selectRadioByValueButton));
        elementsMethods.clickOnElement(selectRadioByValueButton);
    }

    public String getExerciseNumberRadioValue() {
        wait.until(ExpectedConditions.visibilityOf(exerciseNumberRadioValue));
        return exerciseNumberRadioValue.getText();
    }

    // TEST 7 - SELECT AN IMAGE BY ALT TEXT
    @FindBy(xpath = "//button[@data-testid='xp-q-select-image-alt']")
    WebElement selectImageByAltButton;

    public void clickSelectImageByAlt() {
        wait.until(ExpectedConditions.elementToBeClickable(selectImageByAltButton));
        elementsMethods.clickOnElement(selectImageByAltButton);
    }

    // TEST 8 - SELECT A HEADING BY TAG AND TEXT
    @FindBy(xpath = "//button[@data-testid='xp-q-select-heading-text']")
    WebElement selectHeadingByTextButton;

    public void clickSelectHeadingByText() {
        elementsMethods.clickOnElement(selectHeadingByTextButton);
    }

    public boolean isExercise8Active() {
        return selectHeadingByTextButton.getAttribute("class").contains("active");
    }

    // TEST 9 - SELECT A LINK BY HREF
    @FindBy(xpath = "//button[@data-testid='xp-q-select-link-href']")
    WebElement selectLinkByHrefButton;

    public void clickSelectLinkByHref() {
        elementsMethods.clickOnElement(selectLinkByHrefButton);
    }

    public boolean isExercise9Active() {
        return selectLinkByHrefButton.getAttribute("class").contains("active");
    }

    // TEST 10 - SELECT AN A BY ITS ID
    @FindBy(xpath = "//button[@data-testid='xp-q-g001-id-a']")
    WebElement selectAByIdButton;

    public void clickSelectAById() {
        elementsMethods.clickOnElement(selectAByIdButton);
    }

    public boolean isExercise10Active() {
        return selectAByIdButton.getAttribute("class").contains("active");
    }
}