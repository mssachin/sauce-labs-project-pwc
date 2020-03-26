package com.pwc.salesforceprogram.SalesforceTestAutomation.testconfiguration;

import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.SFObjectHandlingMethods;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.SauceUtils;
import com.saucelabs.saucerest.SauceREST;
import io.cucumber.spring.CucumberTestContext;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Component("edge")
@Scope(CucumberTestContext.SCOPE_CUCUMBER_GLUE)
public class EdgeBrowser extends Browser {


    public EdgeBrowser() {
        super(BrowserName.EDGE);
        initializeDriver();
    }


    @Override
    protected void initializeDriver() {
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "latest");
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
        sauceREST = new SauceREST(saucelabsProperties.getProperty("sauce.username"), saucelabsProperties.getProperty("sauce.accessKey"),"EU");
        sauceUtils = new SauceUtils(sauceREST);
        sfObjectHandlingMethods = new SFObjectHandlingMethods(driver, wait);

    }
}
