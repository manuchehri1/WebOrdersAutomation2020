package com.weborders.tests;

import com.weborders.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest{

    @Test(dataProvider = "smokeTestData")
    public void smokeTest(String component,String expectedPageSubtitle){
        extentTest = extentReports.createTest("Verify"+component);


        LoginPage loginPage = new LoginPage();
        loginPage.login();
        loginPage.navigateTo(component);
        Assert.assertEquals(loginPage.getPageSubtitleText(),expectedPageSubtitle);

        extentTest.pass(component+"verified");
    }


    @DataProvider(parallel = true)
    public Object[][] smokeTestData(){
        return new Object[][]{
                {"View all orders","List of All Orders"},
                {"View all products","List of Products"},
                {"Order","Order"}

        };
    }


}
