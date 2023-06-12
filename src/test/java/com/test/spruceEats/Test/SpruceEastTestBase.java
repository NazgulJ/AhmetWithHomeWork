package com.test.spruceEats.Test;

import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SpruceEastTestBase {

    public WebDriver driver;

        @BeforeMethod
        public void setup() {
            driver = DriverHelper.getDriver();
            driver.get("https://www.thespruceeats.com/");
              }
              @AfterMethod
      public void tearDown(){
            // driver.quit();
      }
   }

