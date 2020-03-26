package com.pwc.salesforceprogram.SalesforceTestAutomation.stepdefinitions;

import com.pwc.salesforceprogram.SalesforceTestAutomation.actions.CreatesACase;
import com.pwc.salesforceprogram.SalesforceTestAutomation.actions.ExecuteAction;
import com.pwc.salesforceprogram.SalesforceTestAutomation.states.ExtractOutcome;
import com.pwc.salesforceprogram.SalesforceTestAutomation.states.SubjectOfCaseCreated;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.AppUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.annotation.DirtiesContext;

import java.util.HashMap;
import java.util.Map;

@DirtiesContext
public class LoginSteps{


    private CreatesACase createsACase;
    private SubjectOfCaseCreated subjectOfCaseCreated;
    private String expectedSubjectOfCaseCreated;

    @When("Business User creates a new case")
    public void business_User_creates_a_new_case(Map<String, String> caseDetails) {
        Map<String,String> caseDetailsAsInputMap = new HashMap<>();
        caseDetailsAsInputMap.put("caseOrigin", caseDetails.get("Case Origin"));
        expectedSubjectOfCaseCreated = caseDetails.get("Subject")+ " "+ System.currentTimeMillis();
        caseDetailsAsInputMap.put("caseSubject", expectedSubjectOfCaseCreated);
        String caseDetailsAsString = AppUtilities.convertMapToJSONString(caseDetailsAsInputMap);
        createsACase = new CreatesACase(caseDetailsAsString);
        new ExecuteAction(createsACase);
    }

    @Then("Business User sees that a case is created")
    public void business_User_sees_that_a_case_is_created() {
        subjectOfCaseCreated = new SubjectOfCaseCreated();
        String actualSubjectOfCaseCreate = (String)ExtractOutcome.of(subjectOfCaseCreated);
        Assertions.assertEquals(expectedSubjectOfCaseCreated, actualSubjectOfCaseCreate);

    }



}

