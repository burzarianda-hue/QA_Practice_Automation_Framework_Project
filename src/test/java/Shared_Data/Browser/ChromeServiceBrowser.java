package Shared_Data.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeServiceBrowser implements IBrowserService {

    private WebDriver driver;

    @Override
    public void openBrowser() {

        ChromeOptions options = (ChromeOptions) browserOptions();

        driver = new ChromeDriver(options);
    }

    @Override
    public Object browserOptions() {

        ChromeOptions options = new ChromeOptions();

        boolean ciCd = Boolean.parseBoolean(
                System.getProperty("ci_cd", "false")
        );

        if (ciCd) {

            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");

        } else {

            options.addArguments("--start-maximized");

            options.addArguments(
                    "--user-data-dir=C:\\SeleniumChromeProfile"
            );
        }

        return options;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
