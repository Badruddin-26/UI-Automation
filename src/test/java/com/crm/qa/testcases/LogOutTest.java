package com.crm.qa.testcases;

import com.crm.qa.pages.LogOutPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LogOutTest extends TestBase{

   LogOutPage logOutPage;


    public LogOutTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        logOutPage = new LogOutPage();
    }

    @Test
    public void loginPageAndNavigateToElectronicPage(){
        String title = logOutPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
        logOutPage.validateAndClickSignInButton();
        logOutPage.navigateToUNSignInPage(prop.getProperty("username"));
        logOutPage.navigateToPWDSignInPage(prop.getProperty("password"));
        logOutPage.logOutAndNavigateToSignInPage();
    }





    @AfterMethod
    public void tearDown(){
        driver.quit();
    }





}
