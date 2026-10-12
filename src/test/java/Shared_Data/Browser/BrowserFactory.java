package Shared_Data.Browser;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    private WebDriver driver;

    public WebDriver getBrowserFactory() {

        String browser = BrowserType.BROWSER_CHROME;

        if (browser.equals(BrowserType.BROWSER_CHROME)) {

            ChromeServiceBrowser chromeService = new ChromeServiceBrowser();

            chromeService.openBrowser();

            driver = chromeService.getDriver();

        } else if (browser.equals(BrowserType.BROWSER_EDGE)) {

            EdgeServiceBrowser edgeServiceBrowser = new EdgeServiceBrowser();

            edgeServiceBrowser.openBrowser();

            driver = edgeServiceBrowser.getDriver();
        }

        return driver;
    }
}