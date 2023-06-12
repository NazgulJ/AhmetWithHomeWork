package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlazeOrderTest extends BlazeTestBase {

    @Test
    public void validateCartItem() throws InterruptedException {

        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);
        blazeHomePage.chooseCategory("Laptops");
        BlazeLaptopsPage laptopsPage=new BlazeLaptopsPage(driver);
        laptopsPage.chooseLaptopBrand("MacBook Pro");
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.clickAddCardButton(driver,"Product added");
        blazeHomePage.clickCardButton();
        BlazeCartPage cartPage=new BlazeCartPage(driver);
        cartPage.getInfoFromCard("MacBook Pro","1100");
        cartPage.clickPlaceOrder();
        BlazeOrderPage blazeOrderPage=new BlazeOrderPage(driver);
        blazeOrderPage.PlaceOrderFunctionality("Nazgul","KG","Bish","1223456677654344","04","1234",
                "Thank you for your purchase!");
        Assert.assertEquals(driver.getCurrentUrl().trim(),"https://www.demoblaze.com/index.html");

    }
}