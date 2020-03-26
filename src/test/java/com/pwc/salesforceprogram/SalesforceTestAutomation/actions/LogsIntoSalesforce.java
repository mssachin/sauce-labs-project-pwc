package com.pwc.salesforceprogram.SalesforceTestAutomation.actions;

import com.pwc.salesforceprogram.SalesforceTestAutomation.pageobjects.commons.LoginPage;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.SFObjectHandlingMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LogsIntoSalesforce {

    private String username;
    private String password;


    public LogsIntoSalesforce(String username, String password) {
        this.username = username;
        this.password = password;

    }

      public void execute(SFObjectHandlingMethods sfObjectHandlingMethods) {
       final String ENVIRONMENT = System.getProperty("environment");
      try {
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//application.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            String URL = properties.getProperty(ENVIRONMENT);
            sfObjectHandlingMethods.launchURL(URL);
        } catch (IOException ioException) {
          ioException.printStackTrace();
      }

        sfObjectHandlingMethods.SFEnterTextInTextBox(LoginPage.USERNAME_FIELD_LOCATOR, username);
        sfObjectHandlingMethods.SFEnterTextInTextBox(LoginPage.PASSWORD_FIELD_LOCATOR, password);
        sfObjectHandlingMethods.SFLinkOrButtonClick(LoginPage.LOGIN_BUTTON_LOCATOR);

    }


}
