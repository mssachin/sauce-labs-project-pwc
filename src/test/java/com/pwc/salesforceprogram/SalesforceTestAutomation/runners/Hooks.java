package com.pwc.salesforceprogram.SalesforceTestAutomation.runners;



import com.pwc.salesforceprogram.SalesforceTestAutomation.testconfiguration.Browser;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.ApplicationContextProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.Set;

public class Hooks {


    @After
    public void tearDown(Scenario scenario) {
        final String ENVIRONMENT = System.getProperty("environment");
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        Iterator<Thread> threadIterator = threadSet.iterator();
        while (threadIterator.hasNext()) {
            Thread thread = threadIterator.next();
            if (thread.getName().equalsIgnoreCase("chrome")) {
                Browser browser = (Browser) applicationContext.getBean("chrome");
                browser.sauceUtils.updateResults(!scenario.isFailed(), browser.sessionId, scenario.getName() + " : Chrome in " + ENVIRONMENT);
                browser.getDriver().quit();
            } else if (thread.getName().equalsIgnoreCase("safari")) {
                Browser browser = (Browser) applicationContext.getBean("safari");
                browser.sauceUtils.updateResults(!scenario.isFailed(), browser.sessionId, scenario.getName() + " : Chrome in macOS in " + ENVIRONMENT);
                browser.getDriver().quit();
            } else if (thread.getName().equalsIgnoreCase("edge")) {
                Browser browser = (Browser) applicationContext.getBean("edge");
                browser.sauceUtils.updateResults(!scenario.isFailed(), browser.sessionId, scenario.getName() + " : Edge in " + ENVIRONMENT);
                browser.getDriver().quit();
            }

        }
    }

    @Before
    public static void setUp(Scenario scenario) {

    }


}
