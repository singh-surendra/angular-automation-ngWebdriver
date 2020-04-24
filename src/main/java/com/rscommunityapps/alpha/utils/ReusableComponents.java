package com.rscommunityapps.alpha.utils;


import com.rscommunityapps.alpha.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.rscommunityapps.alpha.utils.BrowserWait.getFluentWait;
import static com.rscommunityapps.alpha.utils.BrowserWait.waitUntilElementIsPresent;

public class ReusableComponents extends BasePage {


    public String getTextFromLink(){
        return driver.findElement(By.xpath("//a[text()='Members']")).getText();
    }



}
