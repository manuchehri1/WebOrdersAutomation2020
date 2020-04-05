package com.weborders.tests;

import com.weborders.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {



    @Test
    public void login(){
        extentTest = extentReports.createTest("Verify page loge");

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(loginPage.getPageLogoText(),"Web Orders");

        extentTest.pass("Logo verified");
    }
}
