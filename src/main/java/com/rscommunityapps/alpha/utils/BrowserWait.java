package com.rscommunityapps.alpha.utils;


import com.rscommunityapps.alpha.Base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.openqa.selenium.By.cssSelector;

public class BrowserWait extends BasePage {


    public static FluentWait getFluentWait() {
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return fluentWait;
    }

    public static boolean waitUntilElementIsPresent(By by) {
        try {
            getFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }


    public static boolean waitUntilElementClickable(By by) {
        try {
            getFluentWait().until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }


    public static boolean waitUntilLinkIsPresentUsingLinkText(String linkText) {
        try {
            getFluentWait().until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }




}
