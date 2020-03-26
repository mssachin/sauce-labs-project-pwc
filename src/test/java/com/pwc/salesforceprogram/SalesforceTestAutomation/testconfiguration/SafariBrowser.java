package com.pwc.salesforceprogram.SalesforceTestAutomation.testconfiguration;

import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.SFObjectHandlingMethods;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.SauceUtils;
import com.saucelabs.saucerest.SauceREST;
import io.cucumber.spring.CucumberTestContext;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Component("safari")
@Scope(CucumberTestContext.SCOPE_CUCUMBER_GLUE)
public class SafariBrowser extends Browser {


    public SafariBrowser() {
        super(BrowserName.SAFARI);
        initializeDriver();
    }

    @Override
    protected void initializeDriver() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setExperimentalOption("w3c", true);
        browserOptions.setCapability("platformName", "macOS 10.14");
        browserOptions.setCapability("browserVersion", "latest");

    /*    SafariOptions browserOptions = new SafariOptions();
        browserOptions.setCapability("platformName", "macOS 10.12");
        browserOptions.setCapability("browserVersion", "11.0");*/
        MutableCapabilities mutableCapabilities = setSauceOptions();
        browserOptions.setCapability("sauce:options", mutableCapabilities);
        try {
            driver = new RemoteWebDriver(new URL(SAUCE_REMOTE_URL), browserOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().pageLoadTimeout(30000l, TimeUnit.SECONDS);
        sessionId = ((RemoteWebDriver)driver).getSessionId().toString();
        wait = new WebDriverWait(driver, 10);
        sauceREST = new SauceREST(saucelabsProperties.getProperty("sauce.username"), saucelabsProperties.getProperty("sauce.accessKey"), "EU");
        sauceUtils = new SauceUtils(sauceREST);
        sfObjectHandlingMethods = new SFObjectHandlingMethods(driver, wait);

    }
}
