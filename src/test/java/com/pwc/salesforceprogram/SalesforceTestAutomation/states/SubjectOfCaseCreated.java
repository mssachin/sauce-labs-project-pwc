package com.pwc.salesforceprogram.SalesforceTestAutomation.states;

import com.pwc.salesforceprogram.SalesforceTestAutomation.pageobjects.cases.CaseDetailsPage;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.SFObjectHandlingMethods;

public class SubjectOfCaseCreated {

    public String outcome(SFObjectHandlingMethods sfObjectHandlingMethods){
     return sfObjectHandlingMethods.SFAttributeTextFromWebElement(CaseDetailsPage.CASE_SUBJECT_FIELD);
    }
}
