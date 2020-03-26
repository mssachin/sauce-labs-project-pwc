package com.pwc.salesforceprogram.SalesforceTestAutomation.actions;

import com.google.gson.Gson;
import com.pwc.salesforceprogram.SalesforceTestAutomation.pageobjects.cases.CasesHomepage;
import com.pwc.salesforceprogram.SalesforceTestAutomation.pageobjects.cases.CreateANewCasePage;
import com.pwc.salesforceprogram.SalesforceTestAutomation.scenariodataobjects.CaseDetails;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.SFObjectHandlingMethods;

public class CreatesACase {

    private String caseDetailsAsString;

    public CreatesACase(String caseDetailsAsString) {
        this.caseDetailsAsString = caseDetailsAsString;
    }


    public void execute(SFObjectHandlingMethods sfObjectHandlingMethods){
        Gson gson = new Gson();
        CaseDetails caseDetails = gson.fromJson(caseDetailsAsString,CaseDetails.class );
        sfObjectHandlingMethods.SFWaitLinkOrButtonClick(CasesHomepage.NEW_CASE_BUTTON);
        sfObjectHandlingMethods.SFWaitLinkOrButtonClick(CreateANewCasePage.CASE_ORIGIN_DROPDOWN);
        sfObjectHandlingMethods.SFWaitLinkOrButtonClick(CreateANewCasePage.selectCaseOrigin(caseDetails.getCaseOrigin()));
        sfObjectHandlingMethods.SFEnterTextInTextBox(CreateANewCasePage.CASE_SUBJECT_INPUT, caseDetails.getCaseSubject());
        sfObjectHandlingMethods.SFWaitLinkOrButtonClick(CreateANewCasePage.CASE_SAVE_BUTTON);
    }
}
