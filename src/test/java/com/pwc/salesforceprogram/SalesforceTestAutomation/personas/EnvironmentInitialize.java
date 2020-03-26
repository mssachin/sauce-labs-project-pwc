package com.pwc.salesforceprogram.SalesforceTestAutomation.personas;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class EnvironmentInitialize {


    public  synchronized Map<String, String> getLoginCredentials(String personaName){
        final String ENVIRONMENT = System.getProperty("environment");
        String username = null;
        String password = null;
        Map<String, String> loginCredentials = new HashMap<>();

        Persona persona =  Persona.getPersona(personaName);
        try {
            username = persona.getUsernameBasedOnPersonaAndEnvironment(personaName, ENVIRONMENT);
            password = persona.getPasswordBasedOnPersonaAndEnvironment(personaName, ENVIRONMENT);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        loginCredentials.put("Username", username);
        loginCredentials.put("Password", password);
        return loginCredentials;
    }

}

