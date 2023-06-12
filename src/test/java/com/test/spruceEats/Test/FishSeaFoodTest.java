package com.test.spruceEats.Test;

import com.test.spruceEats.Page.FishSeafoodPage;
import com.test.spruceEats.Page.HomePage;
import org.testng.annotations.Test;

public class FishSeaFoodTest extends  SpruceEastTestBase {
    @Test
    public void IngredientsFunctionality() throws InterruptedException {

        HomePage spruceEatsHomePage = new HomePage(driver);
        spruceEatsHomePage.chooseCategory(driver, "Fish & SeaFood");
        FishSeafoodPage fishSeafoodPage = new FishSeafoodPage(driver);
        fishSeafoodPage.FishForDinnerInput(driver, "Fish food dinner");
    }
}