package com.test.spruceEats.Page;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishSeafoodPage {

    public FishSeafoodPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='search-form-input']")
    WebElement searchText;

    @FindBy(xpath = "//button[@class='comp search-form__btn button btn']")
    WebElement searchButton;

    public void FishForDinnerInput(WebDriver driver, String name) throws InterruptedException {
        BrowserUtils.scrollWithJS(driver,searchText);
        searchText.sendKeys(name);
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver,searchButton);
        Thread.sleep(1000);
        //searchText.sendKeys(Keys.ARROW_DOWN);
        BrowserUtils.clickWithJS(driver,searchButton);

    }

}