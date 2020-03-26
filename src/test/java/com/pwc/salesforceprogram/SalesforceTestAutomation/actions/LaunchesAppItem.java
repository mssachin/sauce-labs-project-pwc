package com.pwc.salesforceprogram.SalesforceTestAutomation.actions;

import com.pwc.salesforceprogram.SalesforceTestAutomation.pageobjects.commons.Homepage;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.SFObjectHandlingMethods;

public class LaunchesAppItem {

    private String appItemName;

    public LaunchesAppItem(String appItemName) {
        this.appItemName = appItemName;
    }

    public void execute(SFObjectHandlingMethods sfObjectHandlingMethods) {
        sfObjectHandlingMethods.SFWaitLinkOrButtonClick(Homepage.APP_LAUNCHER_MENU);
        sfObjectHandlingMethods.SFWaitLinkOrButtonClick(Homepage.launchAppItem(appItemName));
    }
}
