package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazeOrderPage {
    public BlazeOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

@FindBy(xpath = "//input[@id='name']")
    WebElement nameBox;
@FindBy(xpath = "//input[@id='country']")
    WebElement countryBox;
@FindBy(xpath = "//input[@id='city']")
    WebElement cityBox;
@FindBy(xpath ="//input[@id='card']")
    WebElement cardBox;
@FindBy(xpath = "//input[@id='month']")
    WebElement monthBox;
@FindBy(xpath = "//input[@id='year']")
    WebElement yearBox;
@FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    WebElement purchaseButton;
@FindBy(xpath = "//h2[.='Thank you for your purchase!']")
  WebElement message;
    @FindBy(xpath ="//button[.='OK']")
    WebElement okButton;

public void PlaceOrderFunctionality(String name,String country, String city, String card, String month, String year,String expectedmessage) throws InterruptedException {
   Thread.sleep(1000);
    this.nameBox.sendKeys(name);
    Thread.sleep(1000);

    this.countryBox.sendKeys(country);
    Thread.sleep(1000);

    this.cityBox.sendKeys(city);
    Thread.sleep(1000);

    this.cardBox.sendKeys(card);
    Thread.sleep(1000);

    this.monthBox.sendKeys(month);
    Thread.sleep(1000);

    this.yearBox.sendKeys(year);
    Thread.sleep(1000);

    purchaseButton.click();
    Assert.assertEquals(BrowserUtils.getText(message),expectedmessage);
Thread.sleep(5000);
okButton.click();
}



}
