package com.test.spruceEats.Page;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredientsButton;

    @FindBy(xpath = "//li[@class='global-nav__list-item js-global-nav-item'][3]//li")
    List<WebElement> allCategories;

    public void chooseCategory(WebDriver driver, String option) throws InterruptedException {

        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(ingredientsButton).perform();

        for (int i=0;i<allCategories.size();i++) {
            Thread.sleep(2000);
            if (BrowserUtils.getText(allCategories.get(i)).equals(option.toUpperCase())) {
                actions.click(allCategories.get(i)).perform();
                Thread.sleep(2000);
                break;
            }
        }
    }
}

