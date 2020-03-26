package com.pwc.salesforceprogram.SalesforceTestAutomation.utilities;

import io.cucumber.spring.CucumberTestContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("applicationContext")
@Scope(CucumberTestContext.SCOPE_CUCUMBER_GLUE)
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    private ApplicationContextProvider(){}

    public static ApplicationContext getApplicationContext() {
        return context;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;

    }
}
