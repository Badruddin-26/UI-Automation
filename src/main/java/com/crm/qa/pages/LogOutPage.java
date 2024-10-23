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
import java.util.concurrent.TimeUnit;

public class LogOutPage extends TestBase{





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

    @FindBy(xpath="//span[text()=\"Sign Out\"]")
    WebElement signOutLink;


    @FindBy(xpath="//input[@id=\"signInSubmit\"]")
    WebElement singInBtn;


    @FindBy(xpath="//span[@id=\"nav-search-label-id\"]")
    WebElement eletronicHWPage;


    @FindBy(xpath = "//a[@data-nav-ref=\"nav_signin\"]")
    WebElement linkToUrl;

    @FindBy(xpath = "//h1[@class=\"a-spacing-small\"]")
    WebElement signInText;



    @FindBy(xpath="//a[@data-nav-ref=\"nav_youraccount_btn\"]")
    WebElement profileNavigate;


    public LogOutPage(){
        PageFactory.initElements(driver, this);
    }

    JavascriptExecutor js = (JavascriptExecutor)driver;


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
//		 linkToUrl.click();
        String str = driver.findElement(By.xpath("//h1[contains(text(),\"Sign in\")]")).getText();
        System.out.println(str);
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

    public void logOutAndNavigateToSignInPage(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        action.moveToElement(profileNavigate).perform();
        js.executeScript("arguments[0].click();", signOutLink);
        Assert.assertEquals(signInText.getText(),"Sign in");


    }



}
