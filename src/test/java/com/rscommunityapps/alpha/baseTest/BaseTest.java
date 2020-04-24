package com.rscommunityapps.alpha.baseTest;

import com.rscommunityapps.alpha.Base.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

import static com.rscommunityapps.alpha.Base.BasePage.getDriver;


@Slf4j
public class BaseTest {

    public BasePage basePage;
    public WebDriver driver;
    public Properties prop;

    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser() throws InterruptedException {
        log.info("Starting Browser");
        basePage = new BasePage();
        prop = basePage.initialize_Properties();
        driver = basePage.initialize_driver();
        driver.get(prop.getProperty("url"));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Closing Browser");
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}





