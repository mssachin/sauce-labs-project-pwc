package com.pwc.salesforceprogram.SalesforceTestAutomation.pageobjects.cases;

import org.openqa.selenium.By;

public class CreateANewCasePage {

    public static final By CASE_ORIGIN_DROPDOWN = By.xpath("//span[text()='Case Origin']/parent::span/following-sibling::div");
    public static final By CASE_SUBJECT_INPUT = By.xpath("//span[text()='Subject']/parent::label/following-sibling::input");
    public static final By CASE_SAVE_BUTTON = By.xpath("//div[@class='inlineFooter']//span[text()='Save']");


    public static By selectCaseOrigin(String caseOrigin){
        return By.xpath("//a[@title='"+caseOrigin+"']");
    }
}
