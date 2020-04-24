package com.rscommunityapps.alpha.pages.login;


import com.rscommunityapps.alpha.utils.BrowserWait;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import javax.validation.constraints.NotNull;

import static com.rscommunityapps.alpha.utils.BrowserActions.*;
import static com.rscommunityapps.alpha.pages.login.LoginPageLocators.*;


@Slf4j
public class LoginPage extends BrowserWait {


    @Step("verifying login button link is displayed")
    public boolean verifyLoginButtonLink() {
        return waitUntilElementIsPresent(LOGIN_BTN_LINK_TEXT);
    }

    @Step("Getting login page main header text")
    public String getLoginPageHeaderText() {
        return getTextFromElement(LOGIN_PAGE_HEADER_TEXT);
    }

    @Step("Getting login page account header text")
    public String getLoginFormAccountHeaderText() {
        return getTextFromElement(LOGIN_PAGE_ACCOUNT_HEADER_TEXT);
    }

    @Step("Getting username label text")
    public String getUserNameLabelText() {
        return getTextFromElement(USERNAME_LABEL_TEXT);
    }

    @Step("Getting password label text")
    public String getPasswordLabelText() {
        return getTextFromElement(PASSWORD_LABEL_TEXT);
    }

    @Step("verifying login button is displayed")
    public boolean verifyLoginButton() {
        return waitUntilElementIsPresent(LOGIN_BTN_XPATH);
    }


    public void login(@NotNull String username, @NotNull String password) {
        waitUntilElementIsPresent(LOGIN_BTN_XPATH);
        waitUntilElementIsPresent(EMAIL_FIELD_XPATH);
        clearAndfillInFieldWith(EMAIL_FIELD_XPATH, username);
        waitUntilElementIsPresent(PASSWORD_FIELD_XPATH);
        clearAndfillInFieldWith(PASSWORD_FIELD_XPATH, password);
        clickLoginButton();
    }

    public void clickLoginButton() {
        log.info("Clicking login button");
        waitUntilElementClickable(LOGIN_BTN_XPATH);
        clickElementBy(LOGIN_BTN_XPATH);
    }

    public boolean verifyLoginPageIsDisplayed(){
         return waitUntilElementIsPresent(USERNAME_LABEL_TEXT);
    }

    public String getloginErrorMessage(){
        return getTextFromElement(LOGIN_ERROR_TEXT);

    }
}
