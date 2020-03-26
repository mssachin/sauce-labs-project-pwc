package com.pwc.salesforceprogram.SalesforceTestAutomation.testconfiguration;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.ApplicationContextProvider;
import com.pwc.salesforceprogram.SalesforceTestAutomation.utilities.EnvironmentConfig;
import io.cucumber.spring.CucumberTestContext;
import org.springframework.beans.factory.config.MethodInvokingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


@Component("init")
@Scope(CucumberTestContext.SCOPE_CUCUMBER_GLUE)
public class InitiateContext {

    private static List<TestContext> testContexts = new ArrayList<>();


    public InitiateContext() {


        EnvironmentConfig[] environmentConfigs = prepareEnvironmentConfig();
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();

        for(EnvironmentConfig environmentConfig: environmentConfigs) {
            String browserName = environmentConfig.getBrowser();
            TestContext context =applicationContext.getBean(TestContext.class);
            MethodInvokingBean methodInvokingBean = new MethodInvokingBean();
            methodInvokingBean.setTargetObject(context);
            methodInvokingBean.setTargetMethod("setBrowserName");
            methodInvokingBean.setArguments(browserName);
            try {
                methodInvokingBean.prepare();
                methodInvokingBean.invoke();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            testContexts.add(context);
        }


    }

    public static List<TestContext> getTestContexts() {
        return testContexts;
    }


    private static EnvironmentConfig[] prepareEnvironmentConfig(){
        Gson gson = new Gson();
        EnvironmentConfig[] environmentConfigs = new EnvironmentConfig[0];
        try {
            JsonReader reader = new JsonReader(new FileReader(System.getProperty("user.dir")+"//src//main//resources//environmentConfig.json"));
            environmentConfigs = gson.fromJson(reader, EnvironmentConfig[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return environmentConfigs;
    }



}

