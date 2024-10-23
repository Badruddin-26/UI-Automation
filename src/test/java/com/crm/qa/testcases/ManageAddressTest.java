package com.crm.qa.testcases;


import com.crm.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import org.testng.annotations.Test;

import static com.crm.qa.base.TestBase.*;

public class ManageAddressTest extends TestBase {

    LoginPageTest loginPageTest;

    AddressPage addressPage;

    LoginPage loginPage;

    TestUtil testUtil;


    SearchPage searchPage;

    public ManageAddressTest() {
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
        addressPage = new AddressPage();

//        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void navigateToLoginPageAndAddNewAddress() {
        addressPage.validateAndClickSignInButton();
        addressPage.navigateToUNSignInPage(prop.getProperty("username"));
        addressPage.navigateToPWDSignInPage(prop.getProperty("password"));
        addressPage.manageAddress();
        addressPage.navigateTOAddressPage();
        addressPage.addAndVerifyAddress("Deloitte","8989760909","122011"," h.345, sector B", "Dlf CyberCity", "DLF"," GURUGRAM","HARYANA");


     }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
