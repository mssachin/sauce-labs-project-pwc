package com.pwc.salesforceprogram.SalesforceTestAutomation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@PropertySource(value = {"application.properties"},
        ignoreResourceNotFound = true)
public class SalesforceTestAutomationApp {
    private static final Logger logger = LoggerFactory.getLogger(SalesforceTestAutomationApp.class);

    public static void main(String[] args) {
        SpringApplication.run(SalesforceTestAutomationApp.class, args);
        logger.warn("warning msg");
        logger.error("error msg");
        logger.trace("trace msg");
    }



}

