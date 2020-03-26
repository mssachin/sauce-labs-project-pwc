package com.pwc.salesforceprogram.SalesforceTestAutomation.utilities;

import com.google.gson.Gson;

import java.util.Map;

public class AppUtilities {

    public static String convertMapToJSONString(Map<String,String> mapData){
        Gson gson = new Gson();
        String mapAsString = gson.toJson(mapData);
        return mapAsString;
    }
}
