package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.util.List;

public class SearchPage extends TestBase{

    //Page Factory - OR:


    @FindBy(xpath="//input[@id=\"twotabsearchtextbox\"]")
    WebElement searchBar;

    //input[@id="nav-search-submit-button"]

    @FindBy(xpath=" //input[@id=\"nav-search-submit-button\"]")
    WebElement clickSearchBar;




    @FindBy(xpath="//span[@data-csa-c-type=\"element\" and contains(@data-csa-c-content-id,\"p_123\")]")
    WebElement filterWithValue;








    //Initializing the Page Objects:
    public SearchPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public void searchForItem(){
        searchBar.sendKeys("Mobile");
        clickSearchBar.click();
     }

    public void filterItem(String brand){
      WebElement element = driver.findElement(By.xpath("//li[@aria-label='"+brand+"']"));
      Assert.assertEquals(element.getText(), brand);
      element =  driver.findElement(By.xpath("//li[@aria-label='"+brand+"']//input[@type=\"checkbox\"]"));
      Actions act= new Actions(driver);
      act.moveToElement(element).click().build().perform();
}

    public void validateFilterItem(String brand) {
        List<WebElement> list = driver.findElements(By.xpath("//div[@data-component-type=\"s-search-result\"]//span[contains(text(),'"+brand+"')]"));
        for(int i=0;i<list.size();i++){
            if(list.get(i).getText().equalsIgnoreCase(brand)){
//                System.out.println(list.get(18).getText());
                Assert.assertEquals(list.get(i).getText(),brand);
            }
        }
    }




}
