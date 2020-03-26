package com.pwc.salesforceprogram.SalesforceTestAutomation.pageobjects.commons;

import org.openqa.selenium.By;

public class Homepage {

    public static final By APP_LAUNCHER_MENU = By.xpath("//button[@class='slds-button']");

    public static By launchAppItem(String itemName){
        return By.xpath("//div[@class ='slds-p-left--small']//a[@title='"+itemName+"']");
    }

}
