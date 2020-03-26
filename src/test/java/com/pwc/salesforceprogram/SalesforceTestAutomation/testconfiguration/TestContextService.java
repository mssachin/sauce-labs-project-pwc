package com.pwc.salesforceprogram.SalesforceTestAutomation.testconfiguration;

import io.cucumber.spring.CucumberTestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(CucumberTestContext.SCOPE_CUCUMBER_GLUE)
public class TestContextService {

    private TaskExecutor taskExecutor;

    @Autowired
    private TestContextService(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }


    public void executeAsync(List<TestContext> testContexts) {
        for (TestContext context: testContexts) {
            taskExecutor.execute(context);
        }
    }



}
