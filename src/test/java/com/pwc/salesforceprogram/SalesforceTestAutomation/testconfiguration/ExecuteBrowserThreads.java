package com.pwc.salesforceprogram.SalesforceTestAutomation.testconfiguration;

import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.ApplicationContextProvider;
import io.cucumber.spring.CucumberTestContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("execute")
@DependsOn("starter")
@Scope(CucumberTestContext.SCOPE_CUCUMBER_GLUE)
public class ExecuteBrowserThreads {

    private ContextStarter contextStarter = ApplicationContextProvider.getApplicationContext().getBean(ContextStarter.class);

    public ExecuteBrowserThreads() {
        if(!ContextStarter.isIsDone()) {
            contextStarter.setService();
        }
    }
}
