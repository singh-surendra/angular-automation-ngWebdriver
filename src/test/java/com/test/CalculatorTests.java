package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CalculatorPage;

public class CalculatorTests {

    CalculatorPage calculatorPage;
    @BeforeTest
    public void setup(){
       calculatorPage = new CalculatorPage();
    }

    @Test(priority = 1)
    public void additionTest(){
        String result = calculatorPage.doSum("10","20");
        Assert.assertEquals(result, "30");
    }

    @Test(priority = 2)
    public void subtractionTest(){
        String result = calculatorPage.doSubtract("100","80");
        Assert.assertEquals(result, "20");
    }




}
