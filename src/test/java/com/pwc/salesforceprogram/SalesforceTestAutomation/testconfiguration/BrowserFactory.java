package com.pwc.salesforceprogram.SalesforceTestAutomation.testconfiguration;

import io.cucumber.spring.CucumberTestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("factory")
@DependsOn({"chrome","safari","edge", "applicationContext"})
@Scope(CucumberTestContext.SCOPE_CUCUMBER_GLUE)
public class BrowserFactory {


    @Autowired
    private ChromeBrowser chromeBrowser;

    @Autowired
    private SafariBrowser safariBrowser;


    @Autowired
    private EdgeBrowser edgeBrowser;

    public  Browser initiateBrowser(BrowserName browserName) {
        Browser browser;
        switch (browserName) {

            case CHROME:
                browser = chromeBrowser;
                break;

            case SAFARI:
                browser = safariBrowser;
                break;

            case EDGE:
                browser = edgeBrowser;
                break;

            default:
                throw new IllegalArgumentException("Please Specify Browser");

        }
        return browser;
    }
}

