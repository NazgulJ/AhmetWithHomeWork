package com.test.spruceEats.Page;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FishFoodForDinnerPage  {

  public  FishFoodForDinnerPage(WebDriver driver){
      PageFactory.initElements(driver,this);

  }
  @FindBy(css = "#starRating_score_4Star")
    WebElement starRatingBox;

  @FindBy(css = "#pop_search_editor")
    WebElement editorChooseBox;

  @FindBy(xpath = "//span[@class='card__underline']")
  WebElement salmonFood;


  public void ValidationRecipeName (WebDriver driver,String expectedName) throws InterruptedException {
 BrowserUtils.clickWithJS(driver,starRatingBox);
      Thread.sleep(2000);

      Thread.sleep(2000);
   BrowserUtils.clickWithJS(driver,editorChooseBox);

Thread.sleep(1000);
      Assert.assertEquals(BrowserUtils.getText(salmonFood),expectedName);
  }
    }


