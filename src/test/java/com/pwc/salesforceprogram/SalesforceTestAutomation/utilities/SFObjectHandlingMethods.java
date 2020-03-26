package com.pwc.salesforceprogram.SalesforceTestAutomation.utilities;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class SFObjectHandlingMethods{


    private WebDriver driver;
    private WebDriverWait wait;

    public SFObjectHandlingMethods(WebDriver driver, WebDriverWait wait) {
      this.driver = driver;
      this.wait = wait;

    }

    public synchronized void launchURL(String url){
        driver.navigate().to(url);
    }

    public synchronized void SFLinkOrButtonClick(By locator) {
        WebElement buttonOrLinkElement = fluentWaitForAnElement(locator);
        buttonOrLinkElement.click();
    }
    public synchronized void SFWaitLinkOrButtonClick(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        //buttonOrLinkElement.click();
    }


    public synchronized void SFEnterTextInTextBox(By locator, String textToEnter) {
        WebElement textBoxElement = fluentWaitForAnElement(locator);
        textBoxElement.sendKeys(textToEnter);
    }

    public String SFExtractTextFromWebElement(By locator) {
        WebElement element = fluentWaitForAnElement(locator);
        return element.getText();
    }
    public String SFAttributeTextFromWebElement(By locator) {
        WebElement element = fluentWaitForAnElement(locator);
        return element.getAttribute("title");
    }


    private  synchronized WebElement fluentWaitForAnElement(final By locator) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30l))
                .pollingEvery(Duration.ofMillis(500l))
                .ignoring(WebDriverException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(ElementNotInteractableException.class);

        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            WebElement elementToReturn = null;
            WebElement element = null;

            public WebElement apply(WebDriver driver) {
                try {
                    element = driver.findElement(locator);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (element.isDisplayed() && element != null) {
                    elementToReturn = element;
                    return elementToReturn;
                }
                return elementToReturn;
            }
        };

        wait.until(function);

        return function.apply(driver);
    }


}
