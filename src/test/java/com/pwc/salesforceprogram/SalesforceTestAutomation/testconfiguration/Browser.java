package com.pwc.salesforceprogram.SalesforceTestAutomation.testconfiguration;

import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.SFObjectHandlingMethods;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.SauceUtils;
import com.saucelabs.saucerest.SauceREST;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public abstract class Browser {

    private BrowserName browserName;

    @Getter(AccessLevel.PUBLIC)
    public WebDriver driver;

    @Getter(AccessLevel.PUBLIC)
    public WebDriverWait wait;

    @Getter(AccessLevel.PUBLIC)
    public SauceUtils sauceUtils;

    @Getter(AccessLevel.PUBLIC)
    public String sessionId;

    @Getter(AccessLevel.PUBLIC)
    public SauceREST sauceREST;

    @Getter(AccessLevel.PUBLIC)
    public SFObjectHandlingMethods sfObjectHandlingMethods;

    protected Properties saucelabsProperties;

    private MutableCapabilities sauceOptions;

    protected static final String SAUCE_REMOTE_URL = "https://ondemand.eu-central-1.saucelabs.com/wd/hub";


    protected Browser(BrowserName browserName) {
        this.browserName = browserName;
        initializeSauceProperties();
    }

    public MutableCapabilities getSauceOptions() {
        return sauceOptions;
    }


    protected abstract void initializeDriver();

    protected void initializeSauceProperties(){
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//saucelabs.properties");
            saucelabsProperties = new Properties();
            saucelabsProperties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public MutableCapabilities setSauceOptions(){
        sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", saucelabsProperties.getProperty("sauce.username"));
        sauceOptions.setCapability("accessKey", saucelabsProperties.getProperty("sauce.accessKey"));
        sauceOptions.setCapability("seleniumVersion", "3.141.59");
        sauceOptions.setCapability("idleTimeout", 90);
        return sauceOptions;
    }


}
