package org.example.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.HashMap;
import java.util.Map;


public class Common_Steps {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        if (System.getProperty("browser").equalsIgnoreCase("chrome")) {
            this.driver = new ChromeDriver(getChromeOptions());
        } else {
            this.driver = new FirefoxDriver();
        }
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        //   options.addArguments("start-maximized");
        options.addArguments("test-type");
        options.addArguments("disable-notifications");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("autofill.profile_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }


    @After(order = 1)
    public void takeScraenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) {

            TakesScreenshot ts = (TakesScreenshot) driver;

            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }

    }


    @After(order = 0)
    public void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(1000);
    }
}
