package pages;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorPage {

    WebDriver driver;
    NgWebDriver ngWebDriver;
    JavascriptExecutor jsDriver;

    ByAngularModel first = ByAngular.model("first");
    ByAngularModel second = ByAngular.model("second");
    ByAngularModel operator = ByAngular.model("operator");
    ByAngularButtonText go = ByAngular.buttonText("Go!");
    By result = By.tagName("h2");

    public CalculatorPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.silentOutput","true");
        jsDriver = (JavascriptExecutor) driver;
        ngWebDriver = new NgWebDriver(jsDriver);
        driver.get("http://localhost:3456/");
        ngWebDriver.waitForAngularRequestsToFinish();
    }

    public String doSum(String v1, String v2) {
        driver.findElement(first).clear();
        driver.findElement(first).sendKeys(v1);
        driver.findElement(second).clear();
        driver.findElement(second).sendKeys(v2);

        driver.findElement(operator).sendKeys("+");
        driver.findElement(go).click();
        ngWebDriver.waitForAngularRequestsToFinish();
        String sum = driver.findElement(result).getText();
        System.out.println("Result is" + sum);
        return sum;
    }

    public String doSubtract(String v1, String v2) {
        driver.findElement(first).clear();
        driver.findElement(first).sendKeys(v1);
        driver.findElement(second).clear();
        driver.findElement(second).sendKeys(v2);

        driver.findElement(operator).sendKeys("-");
        driver.findElement(go).click();
        ngWebDriver.waitForAngularRequestsToFinish();
        String subtract = driver.findElement(result).getText();
        System.out.println("Result is" + subtract);
        return subtract;
    }


}
