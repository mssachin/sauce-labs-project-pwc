package com.pwc.salesforceprogram.SalesforceTestAutomation.testconfiguration;

import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.SFObjectHandlingMethods;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.SauceUtils;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("base")
@DependsOn("factory")
@Scope("thread")
public class TestContext implements Runnable{


    private Thread t;

    @Getter(AccessLevel.PUBLIC)
    public Browser browser;

    @Getter(AccessLevel.PUBLIC)
    public WebDriver driver;

    @Getter(AccessLevel.PUBLIC)
    public WebDriverWait wait;

    @Getter(AccessLevel.PUBLIC)
    public SauceUtils sauceUtils;

    @Getter(AccessLevel.PUBLIC)
    public String sessionId;

    @Getter(AccessLevel.PUBLIC)
    public SFObjectHandlingMethods sfObjectHandlingMethods;

    @Autowired
    private BrowserFactory browserFactory;


    private String browserName;

    public TestContext() {

    }

    public void setBrowserName(String browserName){
        this.browserName = browserName;
    }

    public String getBrowserName() {
        return browserName;
    }

    @Override
    public void run(){
        boolean running = true;

            if (browserName.equalsIgnoreCase("chrome")) {
                Thread.currentThread().setName(this.getBrowserName());
                browser = browserFactory.initiateBrowser(BrowserName.CHROME);
                this.driver = browser.getDriver();
                this.wait = browser.getWait();
                this.sauceUtils = browser.getSauceUtils();
                this.sessionId = browser.getSessionId();
            } else if (browserName.equalsIgnoreCase("safari")) {
                Thread.currentThread().setName(this.getBrowserName());
                browser = browserFactory.initiateBrowser(BrowserName.SAFARI);
                this.driver = browser.getDriver();
                this.wait = browser.getWait();
                this.sauceUtils = browser.getSauceUtils();
                this.sessionId = browser.getSessionId();
            }else if (browserName.equalsIgnoreCase("edge")) {
                Thread.currentThread().setName(this.getBrowserName());
                browser = browserFactory.initiateBrowser(BrowserName.EDGE);
                this.driver = browser.getDriver();
                this.wait = browser.getWait();
                this.sauceUtils = browser.getSauceUtils();
                this.sessionId = browser.getSessionId();
            }
        while(running) {
            if (Thread.interrupted()) {
                return;
            }
        }

    }
}
