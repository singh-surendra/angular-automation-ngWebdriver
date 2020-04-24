package com.rscommunityapps.alpha.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@Slf4j
public class BrowserActions extends BrowserWait {


    public static void clickElementBy(By by) {
        tryFindElement(by).click();
    }

    public static void clearAndfillInFieldWith(By by, String text) {
        tryFindElement(by).clear();
        tryFindElement(by).sendKeys(text);
    }

    public static WebElement tryFindElement(By by) {
        WebElement element = (WebElement) getFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }

    public static String getPageTitle() {
        return driver.getTitle();
    }

    public static String getTextFromElement(By by) {
        return tryFindElement(by).getText();
    }

    public static WebElement tryFindElementByLinkText(String linkText) {
        WebElement element = (WebElement) getFluentWait().until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
        return element;
    }

    public static void clickElementByLinkText(String linktext) {
        tryFindElementByLinkText(linktext).click();
    }


    /**
     * Accepts an alert
     */
    public static void accept() {
        log.info("Start accepting alert");
        Alert alert = (Alert) getFluentWait()
                .until(ExpectedConditions.alertIsPresent());
        alert.accept();
        log.info("Accepted alert");
    }

    /**
     * dissmisses alert
     */
    public static void dissmiss() {
        log.info("Start dismissing alert");
        Alert alert = (Alert) getFluentWait()
                .until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        log.info("Dismissed alert");
    }

    public static boolean alertExists() {
        log.info("check if alert is there");
        try {
            getFluentWait()
                    .until(ExpectedConditions.alertIsPresent());
            log.info("Alert found");
            return true;
        } catch (NoAlertPresentException e) {
            log.info("Alert not found");
            return false;
        }

    }

    public static String getPageURL() {
        return driver.getCurrentUrl();
    }

    public static void selectFromDropDownByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public static void enterTextAndSelectFirstFromSuggestedList(By by, String text) {
        clearAndfillInFieldWith(by, text);
        List<WebElement> optionsToSelect = driver.findElements(By.className("uib-typeahead-match ng-scope"));
        for (WebElement option : optionsToSelect) {
            System.out.println(option);
            if (option.getText().contains(text)) {
                System.out.println("Trying to select: " + text);
                option.click();
                break;
            }

        }
//        clickElementBy(by);
//        Thread.sleep(500);
        clickElementBy(By.xpath("//*[@id=\"markMemberAttendenceForm\"]/div[1]/div//following-sibling::a[1]"));
//        tryFindElement(by).sendKeys(Keys.TAB);

//        Actions act = new Actions(driver);
//        act.key
//        clickElementBy(By.xpath("//a[@tabindex='-1']"));
    }

    public static boolean checkIfElementContainsText(By by, String text) {
        String expectedText = text.toLowerCase();
        String actualText = tryFindElement(by).getText().toLowerCase();
        return actualText.contains(expectedText);
    }


}
