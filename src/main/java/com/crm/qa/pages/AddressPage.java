package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddressPage extends TestBase{



    //Page Factory - OR:



    @FindBy(xpath="//button[contains(text(),'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(xpath="//a[@data-nav-ref=\"nav_ya_signin\"]")
    WebElement signInLogo;


    @FindBy(xpath="//label[@for=\"ap_password\"]")
    WebElement pwSgnInPge;


    @FindBy(xpath="//span[text()=\"Your Account\"]")
    WebElement manageProfileLink;


    @FindBy(xpath="//*[@id=\"a-page\"]/div[1]/div/div[1]/h1")
    WebElement yourAccountText;



    @FindBy(xpath="//input[@id=\"ap_email\"]")
    WebElement userName;

    @FindBy(xpath="//input[@type=\"password\"]")
    WebElement password;

    @FindBy(xpath="//a[@data-csa-c-content-id=\"nav_cs_electronics\"]")
    WebElement electronicPage;



    @FindBy(xpath="//a[@data-nav-ref=\"nav_youraccount_btn\"]")
    WebElement profileNavigate;


    @FindBy(xpath="//h1[contains(text(),\"Sign in\")]")
    WebElement signInPage;

    //input[@id="continue"]
    @FindBy(xpath="//input[@id=\"continue\"]")
    WebElement continueBtn;


    @FindBy(xpath="//input[@id=\"signInSubmit\"]")
    WebElement singInBtn;


    @FindBy(xpath="//span[@id=\"nav-search-label-id\"]")
    WebElement eletronicHWPage;



    @FindBy(xpath="//div[@data-card-identifier=\"AddressesAnd1Click\"]")
    WebElement YourAddressLink;


    @FindBy(xpath = "//a[@data-nav-ref=\"nav_signin\"]")
    WebElement linkToUrl;
    //Initializing the Page Objects:

    @FindBy(xpath = "//h1[@class=\"a-spacing-medium\"]")
    WebElement YourAddressText;


    @FindBy(xpath = "//div[@class=\"a-box first-desktop-address-tile\"]")
    WebElement addAddressTab;


    @FindBy(xpath = "//h2[contains(text(),\"Add a new address\")]")
    WebElement addAdressPage;


    @FindBy(xpath = "//input[@id=\"address-ui-widgets-enterAddressFullName\"]")
    WebElement fullnameTextBox;

    @FindBy(xpath = "//input[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]")
    WebElement phoneNumberTextBox;

    @FindBy(xpath = "//input[@id=\"address-ui-widgets-enterAddressPostalCode\"]")
    WebElement postalTextBox;

    @FindBy(xpath = "//input[@id=\"address-ui-widgets-enterAddressLine1\"]")
    WebElement addressLine1TextBox;

    @FindBy(xpath = "//input[@id=\"address-ui-widgets-enterAddressLine2\"]")
    WebElement addressLine2TextBox;

    @FindBy(xpath = "//input[@id=\"address-ui-widgets-landmark\"]")
    WebElement landMarkTextBox;

    @FindBy(xpath = "//input[@id=\"address-ui-widgets-enterAddressCity\"]")
    WebElement cityTextBox;

    @FindBy(id = "address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")
    WebElement stateBarSelect;

//    @FindBy(xpath = "//li[@class=\"a-dropdown-item\"]//a[text()=\"ANDAMAN & NICOBAR ISLANDS\"]")
//    WebElement stateDropDown;

    @FindBy(xpath = "//input[@aria-labelledby=\"address-ui-widgets-form-submit-button-announce\"]")
    WebElement addAdressButton;

    @FindBy(xpath = "//h4[text()=\"Address saved\"]")
    WebElement savedAddressBar;


    //Initializing the Page Objects:
    public AddressPage(){

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

    public void manageAddress(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        action.moveToElement(profileNavigate).perform();
        js.executeScript("arguments[0].click();", manageProfileLink);
        Assert.assertEquals(yourAccountText.getText(),"Your Account");
  }

  public void navigateTOAddressPage(){
      YourAddressLink.click();
      Assert.assertEquals(YourAddressText.getText(),"Your Addresses");
      addAddressTab.click();
      Assert.assertEquals(addAdressPage.getText(),"Add a new address");
  }

  public void addAndVerifyAddress(String name, String phoneNumber,String pincode, String flatNo, String area, String landMark, String town, String state){
      fullnameTextBox.sendKeys(name);
      phoneNumberTextBox.sendKeys(phoneNumber);
      postalTextBox.sendKeys(pincode);
      addressLine1TextBox.sendKeys(flatNo);
      addressLine2TextBox.sendKeys(area);
      landMarkTextBox.sendKeys(landMark);
      cityTextBox.sendKeys(town);
      Select stateValue = new Select(driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")));
      stateValue.selectByVisibleText(state);
//      js.executeScript("arguments[0].scrollIntoView()", addAdressButton);
      addAdressButton.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      Assert.assertEquals(savedAddressBar.getText(),"Address saved");
      String name1 = driver.findElement(By.xpath("(//div[@class=\"a-column a-span4 a-spacing-none a-spacing-top-mini address-column\"]//span[text()='"+name+"'])[1]")).getText();
      Assert.assertEquals(name1,name);
      String phone1 = driver.findElement(By.xpath("(//div[@class=\"a-column a-span4 a-spacing-none a-spacing-top-mini address-column\"]//span[contains(text(),'"+phoneNumber+"')])[1]")).getText();
      Assert.assertEquals(phone1,"Phone Number: "+phoneNumber);
      String addline1 = driver.findElement(By.xpath("(//div[@class=\"a-column a-span4 a-spacing-none a-spacing-top-mini address-column\"]//span[contains(text(),'"+flatNo+"')])[1]")).getText();
      Assert.assertEquals(addline1,flatNo);
      String addline2 = driver.findElement(By.xpath("(//div[@class=\"a-column a-span4 a-spacing-none a-spacing-top-mini address-column\"]//span[contains(text(),'"+area+"')])[1]")).getText();
      Assert.assertEquals(addline2,area);


      //







  }
















}
