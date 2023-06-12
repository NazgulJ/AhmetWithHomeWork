package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BlazeCartPage {
    public BlazeCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//tr[@class='success']")
    List<WebElement> information;
    @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement placeOrderButton;

    public void getInfoFromCard(String expectedTitle, String expectedPrice){  //picture title price delete
        List<String> expectedInfo= Arrays.asList("","MacBook Pro","1100");
        for(int i=0; i<information.size()-1;i++){
            Assert.assertEquals(BrowserUtils.getText(information.get(i)),expectedInfo.get(i));

        }
    }
    public void clickPlaceOrder(){
       placeOrderButton.click();
    }
}
