package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MacBookProPage {
    public  MacBookProPage (WebDriver driver){
        PageFactory.initElements(driver, this);

    }
    @FindBy(tagName = "h2")
    WebElement header;

    @FindBy(xpath = "//h3[@class='price-container']")
    WebElement price;

    @FindBy(xpath = "//div[@id='more-information']")
    WebElement description;

    @FindBy(linkText = "Add to cart")
    WebElement addCardButton;

    public void macBookProInformation(String expectedHeader,String expectedHeaderprice,String expectedHeaderdescriptions ){
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(price),expectedHeaderprice);
        Assert.assertEquals(BrowserUtils.getText(description),expectedHeaderdescriptions);
    }
    public void clickAddCardButton(WebDriver driver,String expectedAlertMessage) throws InterruptedException {
        addCardButton.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedAlertMessage);
        alert.accept();
    }
}

