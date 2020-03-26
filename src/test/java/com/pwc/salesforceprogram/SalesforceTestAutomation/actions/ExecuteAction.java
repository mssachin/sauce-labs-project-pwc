package com.pwc.salesforceprogram.SalesforceTestAutomation.actions;


import com.pwc.salesforceprogram.SalesforceTestAutomation.testconfiguration.Browser;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.ApplicationContextProvider;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.SFObjectHandlingMethods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

public class ExecuteAction {

    public ExecuteAction(Object object){

        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        Iterator<Thread> threadIterator = threadSet.iterator();
        while(threadIterator.hasNext()) {
            Thread thread = threadIterator.next();
            if (thread.getName().equalsIgnoreCase("chrome")) {
                Method executeMethod = getExecuteMethod(object);
                SFObjectHandlingMethods sfObjectHandlingMethods = ((Browser)(ApplicationContextProvider.getApplicationContext().getBean("chrome"))).getSfObjectHandlingMethods();
                try {
                    assert executeMethod != null;
                    executeMethod.invoke(object, sfObjectHandlingMethods);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }else if (thread.getName().equalsIgnoreCase("safari")) {
                Method executeMethod = getExecuteMethod(object);
                SFObjectHandlingMethods sfObjectHandlingMethods = ((Browser)(ApplicationContextProvider.getApplicationContext().getBean("safari"))).getSfObjectHandlingMethods();
                try {
                    assert executeMethod != null;
                    executeMethod.invoke(object, sfObjectHandlingMethods);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }else if (thread.getName().equalsIgnoreCase("edge")) {
                Method executeMethod = getExecuteMethod(object);
                SFObjectHandlingMethods sfObjectHandlingMethods = ((Browser)(ApplicationContextProvider.getApplicationContext().getBean("edge"))).getSfObjectHandlingMethods();
                try {
                    assert executeMethod != null;
                    executeMethod.invoke(object, sfObjectHandlingMethods);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private Method getExecuteMethod(Object object){
        Method[] methods = object.getClass().getMethods();
        Method executeMethod = null;
        for(Method method: methods){
            if(method.getName().equalsIgnoreCase("execute")){
                executeMethod = method;
                break;
            }
        }
        return executeMethod;
    }




}
