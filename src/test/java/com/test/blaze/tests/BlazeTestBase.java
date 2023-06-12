package com.test.blaze.tests;

import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BlazeTestBase  {

    public WebDriver driver;

        @BeforeMethod
        public void setup(){
            driver= DriverHelper.getDriver();
            driver.get("https://www.demoblaze.com");
        }
        @AfterMethod
        public void tearDown(){
          // driver.quit();
        }
    }


