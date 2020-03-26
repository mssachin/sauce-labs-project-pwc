package com.pwc.salesforceprogram.SalesforceTestAutomation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/resources/features/"},
        glue = {"com.pwc.salesforceprogram.SalesforceTestAutomation"},
        tags = {"@TagsDemo or @TagsDemoNotExecute"}
        )
public class GenericTestRunner{

        @Before
        public static void setUp() {


        }


}
