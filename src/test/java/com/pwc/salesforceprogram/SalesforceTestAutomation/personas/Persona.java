package com.pwc.salesforceprogram.SalesforceTestAutomation.personas;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public enum Persona {
   BUSINESS_USER("Business User"),
   ADMIN_USER("System Administrator"),
   PRIVATE_USER("Private User");

    private String personaName;


    Persona(String personaName) {
        this.personaName = personaName;
    }

    public static Persona getPersona(String personaName){
        Persona returnPersona= null;
        for(Persona personaToReturn: Persona.values()){
            if(personaToReturn.personaName.equals(personaName)) {
                returnPersona = personaToReturn;
                break;
            }
        }
        return returnPersona;
    }

    public String getUsernameBasedOnPersonaAndEnvironment(String personaName, String environmentName) throws FileNotFoundException {
        String username;
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(new FileReader(System.getProperty("user.dir")+"//src/main//resources//appUsernames.json"), JsonObject.class);
        username = jsonObject.get(environmentName).getAsJsonObject().get(personaName).getAsString();
        return username;
    }
    public String getPasswordBasedOnPersonaAndEnvironment(String personaName, String environmentName) throws FileNotFoundException {
        String password;
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(new FileReader(System.getProperty("user.dir")+"//src/main//resources//appPasswords.json"), JsonObject.class);
        password = jsonObject.get(environmentName).getAsJsonObject().get(personaName).getAsString();
        return password;
    }

}
