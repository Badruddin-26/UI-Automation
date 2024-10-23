package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;

public class LoginPage extends TestBase{


	
	//Page Factory - OR:

	

	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//a[@data-nav-ref=\"nav_ya_signin\"]")
	WebElement signInLogo;


	@FindBy(xpath="//label[@for=\"ap_password\"]")
	WebElement pwSgnInPge;



	@FindBy(xpath="//input[@id=\"ap_email\"]")
	WebElement userName;

	@FindBy(xpath="//input[@type=\"password\"]")
	WebElement password;

	@FindBy(xpath="//a[@data-csa-c-content-id=\"nav_cs_electronics\"]")
	WebElement electronicPage;

	@FindBy(xpath="//h1[contains(text(),\"Sign in\")]")
	WebElement signInPage;

	//input[@id="continue"]
	@FindBy(xpath="//input[@id=\"continue\"]")
	WebElement continueBtn;


	@FindBy(xpath="//input[@id=\"signInSubmit\"]")
	WebElement singInBtn;


	@FindBy(xpath="//span[@id=\"nav-search-label-id\"]")
	WebElement eletronicHWPage;


	@FindBy(xpath = "//a[@data-nav-ref=\"nav_signin\"]")
	WebElement linkToUrl;
	//Initializing the Page Objects:


	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public String validateHMPageTitle(){

		return driver.getTitle();
	}
	public void validateAndClickSignInButton(){
		Actions action = new Actions(driver);
		action.moveToElement(signInLogo).perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", linkToUrl);

		Assert.assertEquals(signInPage.getText(), "Sign in");
	}
	public void navigateToUNSignInPage(String un){

		userName.sendKeys(un);
		continueBtn.click();
	}

	public void navigateToPWDSignInPage(String pw){
		Assert.assertEquals(pwSgnInPge.getText(),"Password");
		password.sendKeys(pw);
		singInBtn.click();

	}

	public void NavigateToElectronicPageAndValidate(){
		electronicPage.click();
		Assert.assertEquals(eletronicHWPage.getText(),"Electronics");
	}
	
//	public HomePage login(String un, String pwd){
////		username.sendKeys(un);
////		password.sendKeys(pwd);
////		//loginBtn.click();
////		    	JavascriptExecutor js = (JavascriptExecutor)driver;
////		    	js.executeScript("arguments[0].click();", loginBtn);
////
//		return new HomePage();
//	}
	
}
