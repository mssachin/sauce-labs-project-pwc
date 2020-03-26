package com.pwc.salesforceprogram.SalesforceTestAutomation.utilities;

import com.saucelabs.saucerest.SauceREST;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;


public class SauceUtils {

    private SauceREST sauceClient;


    public SauceUtils(SauceREST sauceREST) {
        this.sauceClient = sauceREST;
    }

    public void updateResults(boolean testResults, String sessionId, String name)
            throws JSONException {
        Map<String, Object> updates = new HashMap<>();
        updates.put("passed", testResults);
        updates.put("name", name);
        sauceClient.updateJobInfo(sessionId, updates);
    }
}
