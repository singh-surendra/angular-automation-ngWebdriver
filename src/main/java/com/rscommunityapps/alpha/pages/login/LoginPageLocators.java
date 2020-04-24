package com.rscommunityapps.alpha.pages.login;

import org.openqa.selenium.By;

public class LoginPageLocators {

    public static final By LOGIN_BTN_XPATH         = By.xpath("//input[@type='submit']");
    public static final By EMAIL_FIELD_XPATH       = By.xpath("//input[@name='loginuid']");
    public static final By PASSWORD_FIELD_XPATH    = By.xpath("//input[@name='loginpwd']");
    public static final By LOGIN_BTN_LINK_TEXT        = By.linkText("Login");
    public static final By LOGIN_PAGE_HEADER_TEXT        = By.tagName("h1");
    public static final By LOGIN_PAGE_ACCOUNT_HEADER_TEXT        = By.tagName("h4");
    public static final By USERNAME_LABEL_TEXT        = By.cssSelector("#loginForm > div:nth-child(1) > label");
    public static final By PASSWORD_LABEL_TEXT        = By.cssSelector("#loginForm > div:nth-child(2) > label");
    public static final By LOGIN_ERROR_TEXT        = By.xpath("//*[@id='alertBox']");





}
