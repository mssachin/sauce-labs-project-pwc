package com.pwc.salesforceprogram.SalesforceTestAutomation.runners;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static java.lang.Boolean.TRUE;

public class CucumberTestExecutionListener extends AbstractTestExecutionListener {

    private boolean dirtyContext = false;

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        if (dirtyContext) {
            testContext.markApplicationContextDirty(DirtiesContext.HierarchyMode.EXHAUSTIVE);
            testContext.setAttribute(DependencyInjectionTestExecutionListener.REINJECT_DEPENDENCIES_ATTRIBUTE, TRUE);
            dirtyContext = false;
        }
    }
}
