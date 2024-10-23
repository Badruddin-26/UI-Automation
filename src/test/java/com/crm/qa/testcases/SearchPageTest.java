package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.SearchPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.annotations.Test;

public class SearchPageTest extends TestBase {
    LoginPage loginPage;

    TestUtil testUtil;


    SearchPage searchPage;

    public SearchPageTest() {
        super();
    }

    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();

        loginPage = new LoginPage();
        searchPage = new SearchPage();

//        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }


    @Test
    public void SearchItemAndValdidate(){
        String title = searchPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");

        String brand = "Redmi";
        searchPage.searchForItem();
        searchPage.filterItem(brand);
        searchPage.validateFilterItem(brand);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}

