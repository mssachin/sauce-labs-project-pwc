package com.pwc.salesforceprogram.SalesforceTestAutomation.states;


import com.pwc.salesforceprogram.SalesforceTestAutomation.testconfiguration.Browser;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.ApplicationContextProvider;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.SFObjectHandlingMethods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

public class ExtractOutcome {

    public static Object of(Object object){
        Object outcome = null;
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        Iterator<Thread> threadIterator = threadSet.iterator();
        while(threadIterator.hasNext()) {
            Thread thread = threadIterator.next();
            if (thread.getName().equalsIgnoreCase("chrome")) {
                Method outcomeMethod = getOutcomeMethod(object);
                SFObjectHandlingMethods sfObjectHandlingMethods = ((Browser)(ApplicationContextProvider.getApplicationContext().getBean("chrome"))).getSfObjectHandlingMethods();
                try {
                    assert outcomeMethod != null;
                    outcome =  outcomeMethod.invoke(object, sfObjectHandlingMethods);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }else if (thread.getName().equalsIgnoreCase("safari")) {
                Method outcomeMethod = getOutcomeMethod(object);
                SFObjectHandlingMethods sfObjectHandlingMethods = ((Browser)(ApplicationContextProvider.getApplicationContext().getBean("safari"))).getSfObjectHandlingMethods();
                try {
                    assert outcomeMethod != null;
                    outcome = outcomeMethod.invoke(object, sfObjectHandlingMethods);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }else if (thread.getName().equalsIgnoreCase("edge")) {
                Method outcomeMethod = getOutcomeMethod(object);
                SFObjectHandlingMethods sfObjectHandlingMethods = ((Browser)(ApplicationContextProvider.getApplicationContext().getBean("edge"))).getSfObjectHandlingMethods();
                try {
                    assert outcomeMethod != null;
                    outcome = outcomeMethod.invoke(object, sfObjectHandlingMethods);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return outcome;

    }


    private static Method getOutcomeMethod(Object object){
        Method[] methods = object.getClass().getMethods();
        Method executeMethod = null;
        for(Method method: methods){
            if(method.getName().equalsIgnoreCase("outcome")){
                executeMethod = method;
                break;
            }
        }
        return executeMethod;
    }

}
