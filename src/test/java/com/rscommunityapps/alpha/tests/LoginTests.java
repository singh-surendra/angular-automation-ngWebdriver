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

@Story("Login Page functionality")
@Listeners({TestAllureListener.class})
@Owner("Surendra Singh")
public class LoginTests extends BaseTest {


    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ReusableComponents reusableComponents = new ReusableComponents();


    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Login page basic validations- title, login link, h1 header, login form")
    public void loginPageBasicValidations() {
        Assert.assertEquals(getPageTitle(), Constants.LOGIN_PAGE_TITLE);
        Assert.assertTrue(loginPage.verifyLoginButtonLink());
        Assert.assertEquals(loginPage.getLoginPageHeaderText(), Constants.LOGIN_PAGE_HEADER);
        Assert.assertEquals(loginPage.getLoginFormAccountHeaderText(), Constants.ACCOUNT_LOGIN_HEADER);
        Assert.assertEquals(loginPage.getUserNameLabelText(), Constants.LOGIN_FORM_USERNAME_LABEL);
        Assert.assertEquals(loginPage.getPasswordLabelText(), Constants.LOGIN_FORM_PASSWORD_LABEL);
        Assert.assertTrue(loginPage.verifyLoginButton());

    }


    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify admin login is successful")
    public void loginAsAdmin() throws InterruptedException {
        loginPage.login(Constants.ADMIN_USER, Constants.ADMIN_USER_PASSWORD);
        homePage.verifyAdminUserIsLoggedIn(HomePageConstants.ATTENDANCE_LINK_TEXT, HomePageConstants.MEMBERS_LINK_TEXT, HomePageConstants.USERS_LINK_TEXT);
        homePage.logout();
        Assert.assertTrue(loginPage.verifyLoginPageIsDisplayed());
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify volunteer login is successful")
    public void loginAsVolunteer() throws InterruptedException {
        loginPage.login(Constants.VOLUNTEER_USER, Constants.VOLUNTEER_USER_PASSWORD);
        homePage.verifyVolunteerUserIsLoggedIn(HomePageConstants.ATTENDANCE_LINK_TEXT, HomePageConstants.MEMBERS_LINK_TEXT);
        homePage.logout();
        Assert.assertTrue(loginPage.verifyLoginPageIsDisplayed());
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify admin user can logout successfully")
    public void loginAndLogoutAsAdmin() throws InterruptedException {
        loginPage.login(Constants.ADMIN_USER, Constants.ADMIN_USER_PASSWORD);
        homePage.verifyAdminUserIsLoggedIn(HomePageConstants.ATTENDANCE_LINK_TEXT, HomePageConstants.MEMBERS_LINK_TEXT, HomePageConstants.USERS_LINK_TEXT);
        homePage.logout();
        Assert.assertTrue(loginPage.verifyLoginPageIsDisplayed());
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify volunteer user can logout successfully")
    public void loginAndLogoutAsVolunteer() throws InterruptedException {
        loginPage.login(Constants.VOLUNTEER_USER, Constants.VOLUNTEER_USER_PASSWORD);
        homePage.verifyVolunteerUserIsLoggedIn(HomePageConstants.ATTENDANCE_LINK_TEXT, HomePageConstants.MEMBERS_LINK_TEXT);
        homePage.logout();
        Assert.assertTrue(loginPage.verifyLoginPageIsDisplayed());
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify login with incorrect credentials is not successful")
    public void loginWithIncorrectCredentials() throws InterruptedException {
        loginPage.login(getRandomAlphaNumericString(8), getRandomAlphaNumericString(8));
        Thread.sleep(5000);
        Assert.assertEquals(loginPage.getloginErrorMessage(), "invalidlogin \n" +
                "×");
        Assert.assertTrue(loginPage.verifyLoginPageIsDisplayed());
    }


}
