package com.rscommunityapps.alpha.pages.markattendance;

import com.rscommunityapps.alpha.utils.BrowserWait;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import static com.rscommunityapps.alpha.pages.markattendance.MarkAttendancePageLocators.*;
import static com.rscommunityapps.alpha.utils.BrowserActions.*;

@Slf4j
public class MarkAttendancePage extends BrowserWait {

    public void selectRegisteredTab() {
        waitUntilElementClickable(REGISTERED_TAB_XAPTH);
        clickElementBy(REGISTERED_TAB_XAPTH);
    }

    public void selectVisitorsTab() {
        waitUntilElementClickable(VISITORS_TAB_XAPTH);
        clickElementBy(VISITORS_TAB_XAPTH);
    }

    public void selectActivityType(String activityName){
        selectFromDropDownByVisibleText(ACTIVITY_TYPE_CSS,activityName);
    }

    public void enterBranchCodeOrName(String branchCodeOrName){
        enterTextAndSelectFirstFromSuggestedList(BRANCH_CODE_NAME_XPATH,branchCodeOrName);
    }

    public void clickMarkAttendance(){
        waitUntilElementClickable(MARK_BTN);
        clickElementBy(MARK_BTN);
    }

    public boolean checkIfFirstMemberInListIsCorrect(String text){
        System.out.println("text is"+getTextFromElement(FIRST_MEMBER_ROW_XPATH));
        return checkIfElementContainsText(FIRST_MEMBER_ROW_XPATH,text);
    }

}
