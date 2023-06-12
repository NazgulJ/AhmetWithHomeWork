package com.test.spruceEats.Test;

import com.test.spruceEats.Page.FishFoodForDinnerPage;
import com.test.spruceEats.Page.FishSeafoodPage;
import com.test.spruceEats.Page.HomePage;
import org.testng.annotations.Test;

public class FishForDinnerTest extends  SpruceEastTestBase {
    @Test
    public void FishForDinnerTest() throws InterruptedException {

        HomePage spruceEatsHomePage = new HomePage(driver);
        spruceEatsHomePage.chooseCategory(driver, "Fish & SeaFood");
        FishSeafoodPage fishSeafoodPage = new FishSeafoodPage(driver);
        fishSeafoodPage.FishForDinnerInput(driver, "Fish for dinner");
        FishFoodForDinnerPage fishFoodForDinnerPage=new FishFoodForDinnerPage(driver);
        fishFoodForDinnerPage.ValidationRecipeName(driver, "6-Ingredient Roasted Salmon Fillets");

    }
}


