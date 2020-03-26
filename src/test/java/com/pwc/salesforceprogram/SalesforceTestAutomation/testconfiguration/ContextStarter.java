package com.pwc.salesforceprogram.SalesforceTestAutomation.testconfiguration;

import io.cucumber.spring.CucumberTestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("starter")
@DependsOn("init")
@Scope(CucumberTestContext.SCOPE_CUCUMBER_GLUE)
public class ContextStarter {

    @Autowired
    private TestContextService service;

    public static boolean isDone = false;


    public static boolean isIsDone() {
        return isDone;
    }

    public void setService() {
            service.executeAsync(InitiateContext.getTestContexts());
            isDone = true;

    }


}
