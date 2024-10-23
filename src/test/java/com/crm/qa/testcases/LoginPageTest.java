package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;

	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
@Test
	public void loginPageAndNavigateToElectronicPage(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		loginPage.validateAndClickSignInButton();
		loginPage.navigateToUNSignInPage(prop.getProperty("username"));
		loginPage.navigateToPWDSignInPage(prop.getProperty("password"));
		String HPTitle = loginPage.validateHMPageTitle();
		Assert.assertEquals(HPTitle, "Amazon Sign In");
		loginPage.NavigateToElectronicPageAndValidate();
	}





	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
