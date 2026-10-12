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

        // Argumente pentru rularea in GitHub Actions
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Verificam daca testele ruleaza in CI/CD
        boolean ciCd = Boolean.parseBoolean(
                System.getProperty("ci_cd", "false")
        );

        if (ciCd) {

            // Chrome ruleaza fara fereastra vizibila
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");

        } else {

            // Profil local folosit numai in IntelliJ
            options.addArguments(
                    "--user-data-dir=C:\\SeleniumChromeProfile"
            );

            options.addArguments("--start-maximized");
        }

        return options;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
