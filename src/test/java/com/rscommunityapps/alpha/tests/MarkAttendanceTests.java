package com.rscommunityapps.alpha.tests;

import com.rscommunityapps.alpha.baseTest.BaseTest;
import com.rscommunityapps.alpha.constants.Constants;
import com.rscommunityapps.alpha.constants.HomePageConstants;
import com.rscommunityapps.alpha.listeners.TestAllureListener;
import com.rscommunityapps.alpha.pages.home.HomePage;
import com.rscommunityapps.alpha.pages.login.LoginPage;
import com.rscommunityapps.alpha.pages.markattendance.MarkAttendancePage;
import com.rscommunityapps.alpha.utils.ReusableComponents;

import static com.rscommunityapps.alpha.utils.RandomHelper.*;


import static com.rscommunityapps.alpha.utils.BrowserActions.*;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import javax.validation.constraints.AssertTrue;

@Story("Home Page functionality")
@Listeners({TestAllureListener.class})
@Owner("Surendra Singh")

public class MarkAttendanceTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    MarkAttendancePage markAttendancePage = new MarkAttendancePage();


    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify user is able to Mark Attendance for Registered member to one of the activity")
    public void markAttendanceForRegisteredMember() throws InterruptedException {
        loginPage.login(Constants.ADMIN_USER, Constants.ADMIN_USER_PASSWORD);
        clickElementByLinkText(HomePageConstants.ATTENDANCE_LINK_TEXT);
        clickElementByLinkText(HomePageConstants.MARK_ATTENDANCE_LINK_TEXT);
        Assert.assertEquals(getPageURL(),HomePageConstants.MARK_ATTENDANCE_PAGE_URL, "The page url does not match");
        markAttendancePage.selectActivityType("Night Duty");
        markAttendancePage.enterBranchCodeOrName("mukesh");
        Thread.sleep(5000);
        markAttendancePage.clickMarkAttendance();
        Assert.assertTrue(markAttendancePage.checkIfFirstMemberInListIsCorrect("mukesh"));
        Thread.sleep(8000);
    }



}





