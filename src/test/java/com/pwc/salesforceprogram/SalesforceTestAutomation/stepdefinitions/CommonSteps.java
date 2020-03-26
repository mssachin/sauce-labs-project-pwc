package com.pwc.salesforceprogram.SalesforceTestAutomation.stepdefinitions;

import com.pwc.salesforceprogram.SalesforceTestAutomation.actions.ExecuteAction;
import com.pwc.salesforceprogram.SalesforceTestAutomation.actions.LaunchesAppItem;
import com.pwc.salesforceprogram.SalesforceTestAutomation.actions.LogsIntoSalesforce;
import com.pwc.salesforceprogram.SalesforceTestAutomation.personas.EnvironmentInitialize;
import io.cucumber.java.en.Given;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Map;

@DirtiesContext
public class CommonSteps {

    private String username;
    private String password;


    private LogsIntoSalesforce logsIntoSalesforce;
    private LaunchesAppItem launchesAppItem;


    @Given("{string} logs into salesforce and is in the {string} App")
    public void business_User_logs_into_salesforce_and_is_in_the_App(String persona, String appItemName) {
        EnvironmentInitialize environmentInitialize = new EnvironmentInitialize();
        Map<String, String> loginCredentials  = environmentInitialize.getLoginCredentials(persona);
        username = loginCredentials.get("Username");
        password = loginCredentials.get("Password");
        logsIntoSalesforce =new LogsIntoSalesforce(username, password);
        new ExecuteAction(logsIntoSalesforce);
        launchesAppItem = new LaunchesAppItem(appItemName);
        new ExecuteAction(launchesAppItem);
    }
}
