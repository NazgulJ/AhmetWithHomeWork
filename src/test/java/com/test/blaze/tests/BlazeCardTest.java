package com.test.blaze.tests;

import com.test.blaze.pages.BlazeCartPage;
import com.test.blaze.pages.BlazeHomePage;
import com.test.blaze.pages.BlazeLaptopsPage;
import com.test.blaze.pages.MacBookProPage;
import org.testng.annotations.Test;

public class BlazeCardTest extends BlazeTestBase {

    @Test
    public void validateCartItem() throws InterruptedException {

        BlazeHomePage blazeHomePage = new BlazeHomePage(driver);
        blazeHomePage.chooseCategory("Laptops");
        BlazeLaptopsPage laptopsPage = new BlazeLaptopsPage(driver);
        laptopsPage.chooseLaptopBrand("MacBook Pro");
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.clickAddCardButton(driver, "Product added");
        blazeHomePage.clickCardButton();
        BlazeCartPage cartPage = new BlazeCartPage(driver);
        cartPage.getInfoFromCard("MacBook Pro", "1100");
        cartPage.clickPlaceOrder();
    }
}