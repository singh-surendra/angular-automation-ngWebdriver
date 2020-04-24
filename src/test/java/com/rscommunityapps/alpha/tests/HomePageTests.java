package com.rscommunityapps.alpha.tests;

import com.rscommunityapps.alpha.baseTest.BaseTest;
import com.rscommunityapps.alpha.constants.Constants;
import com.rscommunityapps.alpha.constants.HomePageConstants;
import com.rscommunityapps.alpha.listeners.TestAllureListener;
import com.rscommunityapps.alpha.pages.home.HomePage;
import com.rscommunityapps.alpha.pages.login.LoginPage;
import com.rscommunityapps.alpha.utils.ReusableComponents;

import static com.rscommunityapps.alpha.utils.RandomHelper.*;


import static com.rscommunityapps.alpha.utils.BrowserActions.*;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

@Story("Home Page functionality")
@Listeners({TestAllureListener.class})
@Owner("Surendra Singh")

public class HomePageTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Home Page basic validations- menu list, logout button")
    public void homePageBasicValidations() {
        loginPage.login(Constants.ADMIN_USER, Constants.ADMIN_USER_PASSWORD);
        Assert.assertTrue(homePage.checkIfAttendanceMenuIsPresent(HomePageConstants.ATTENDANCE_LINK_TEXT));
        Assert.assertTrue(homePage.checkIfMembersMenuIsPresent(HomePageConstants.MEMBERS_LINK_TEXT));
        Assert.assertTrue(homePage.checkIfUsersMenuIsPresent(HomePageConstants.USERS_LINK_TEXT));
        Assert.assertTrue(homePage.checkIfPremPracharakMenuIsPresent(HomePageConstants.PREM_PRACHARAK_LINK_TEXT));
        Assert.assertTrue(homePage.checkIfIdCardMenuIsPresent(HomePageConstants.IDACRD_LINK_TEXT));
        Assert.assertTrue(homePage.checkIfBhentMenuIsPresent(HomePageConstants.BHENT_LINK_TEXT));
        Assert.assertTrue(homePage.checkIfLogoutButtonIsPresent());
    }

}


