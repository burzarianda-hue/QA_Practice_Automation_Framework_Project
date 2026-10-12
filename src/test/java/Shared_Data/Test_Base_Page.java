package Shared_Data;

import HelperMethods.ScreenshotMethods;
import Logger.LoggerUtility;
import Shared_Data.Browser.BrowserFactory;

import com.aventstack.chaintest.plugins.ChainTestListener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(ChainTestListener.class)
public class Test_Base_Page {

    private WebDriver driver;
    private String testName;

    @BeforeMethod
    public void initialiseBrowser(ITestResult result) {

        testName = result.getMethod().getMethodName();

        LoggerUtility.startTestCase(testName);

        try {
            driver = new BrowserFactory().getBrowserFactory();

            driver.get("https://www.qapractice.com/");

            LoggerUtility.infoTestCase(
                    "Browserul a fost pornit si site-ul QA Practice a fost deschis."
            );

        } catch (RuntimeException exception) {

            LoggerUtility.errorLog(
                    "Eroare la pornirea browserului sau deschiderea site-ului."
            );

            if (driver != null) {
                driver.quit();
            }

            LoggerUtility.endTestCase(testName);

            throw exception;
        }
    }

    @AfterMethod
    public void clearBrowser(ITestResult result) {

        try {
            if (result.getStatus() == ITestResult.SUCCESS) {

                LoggerUtility.infoTestCase(
                        "Testul s-a incheiat cu succes."
                );

            } else if (result.getStatus() == ITestResult.FAILURE) {

                LoggerUtility.errorLog(
                        "Testul a esuat: " + testName
                );

                if (driver != null) {
                    try {
                        // Salvam captura in folderul screenshots.
                        ScreenshotMethods.captureScreenshot(
                                driver,
                                testName
                        );

                        // Atasam captura la testul ChainTest.
                        byte[] screenshot = ((TakesScreenshot) driver)
                                .getScreenshotAs(OutputType.BYTES);

                        ChainTestListener.embed(
                                screenshot,
                                "image/png"
                        );

                        LoggerUtility.infoTestCase(
                                "Screenshot-ul a fost salvat si atasat la ChainTest."
                        );

                    } catch (RuntimeException exception) {

                        LoggerUtility.errorLog(
                                "Nu s-a putut salva sau atasa screenshot-ul: "
                                        + exception.getMessage()
                        );
                    }
                }

            } else {

                LoggerUtility.infoTestCase(
                        "Testul nu s-a incheiat cu succes."
                );
            }

        } finally {

            try {
                if (driver != null) {
                    driver.quit();

                    LoggerUtility.infoTestCase(
                            "Browserul a fost inchis."
                    );
                }

            } finally {
                LoggerUtility.endTestCase(testName);
            }
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
