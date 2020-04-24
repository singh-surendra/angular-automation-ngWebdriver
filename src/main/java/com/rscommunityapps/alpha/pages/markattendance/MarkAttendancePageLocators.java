package com.rscommunityapps.alpha.pages.markattendance;

import org.openqa.selenium.By;

public class MarkAttendancePageLocators {

    public static final By REGISTERED_TAB_XAPTH         = By.xpath("(//div[@class='btn-group']/button)[1]");
    public static final By VISITORS_TAB_XAPTH         = By.xpath("(//div[@class='btn-group']/button)[2]");
    public static final By ACTIVITY_TYPE_CSS        = By.cssSelector("#actions>div>div>div:nth-child(1)>div>select");
    public static final By BRANCH_CODE_NAME_XPATH        = By.xpath("//input[@name='selectedMember']");
    public static final By FIRST_AUTO_SUGGESTED_VALUE        = By.xpath("(//a[@tabindex='-1'])[1]");

    public static final By MARK_BTN        = By.xpath("//*[@id='markMemberAttendenceForm']/div[2]/div[1]/button");
    public static final By CLEAR_BTN        = By.xpath("//*[@id='markMemberAttendenceForm']/div[2]/div[2]/button");
    public static final By FIRST_MEMBER_ROW_XPATH        = By.xpath("//*[@id='historyTable']/tbody/tr[1]");

}
