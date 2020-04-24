package com.rscommunityapps.alpha.pages.home;


import com.rscommunityapps.alpha.utils.BrowserWait;
import io.qameta.allure.Step;

import static com.rscommunityapps.alpha.pages.home.HomePageLocators.*;
import static com.rscommunityapps.alpha.utils.BrowserActions.clickElementBy;

public class HomePage extends BrowserWait {

    public void verifyAdminUserIsLoggedIn(String attendanceLink, String membersLink, String usersLink ) {
         assert waitUntilLinkIsPresentUsingLinkText(attendanceLink);
         assert waitUntilLinkIsPresentUsingLinkText(membersLink);
         assert waitUntilLinkIsPresentUsingLinkText(usersLink);
    }

    public void verifyVolunteerUserIsLoggedIn(String attendanceLink, String membersLink) {
        assert waitUntilLinkIsPresentUsingLinkText(attendanceLink);
        assert! waitUntilLinkIsPresentUsingLinkText(membersLink);
    }

    public void logout(){
        waitUntilElementClickable(LOGOUT_BTN_CSS);
        clickElementBy(LOGOUT_BTN_CSS);
    }

    public boolean checkIfAttendanceMenuIsPresent(String linkText){
        return waitUntilLinkIsPresentUsingLinkText(linkText);
    }

    public boolean checkIfMembersMenuIsPresent(String linkText){
        return waitUntilLinkIsPresentUsingLinkText(linkText);
    }

    public boolean checkIfUsersMenuIsPresent(String linkText){
        return waitUntilLinkIsPresentUsingLinkText(linkText);
    }

    public boolean checkIfPremPracharakMenuIsPresent(String linkText){
        return waitUntilLinkIsPresentUsingLinkText(linkText);
    }

    public boolean checkIfIdCardMenuIsPresent(String linkText){
        return waitUntilLinkIsPresentUsingLinkText(linkText);
    }

    public boolean checkIfBhentMenuIsPresent(String linkText){
        return waitUntilLinkIsPresentUsingLinkText(linkText);
    }

    public boolean checkIfLogoutButtonIsPresent(){
        return waitUntilElementIsPresent(LOGOUT_BTN_CSS);
    }





}
