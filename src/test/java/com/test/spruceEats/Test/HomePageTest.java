package com.test.spruceEats.Test;

import com.test.spruceEats.Page.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends SpruceEastTestBase{

    @Test
        public void IngredientsFunctionality() throws InterruptedException {

            HomePage spruceEatsHomePage = new HomePage(driver);
            spruceEatsHomePage.chooseCategory(driver, "Fish & SeaFood");

    }
}


    /*
1-Navigate to the website "https://www.thespruceeats.com/"
2-Under Ingredients tab --> choose Fish&SeaFood option
3-ScrollDown to the search bar (Use JS Method)
4-Send the data: "Fish for dinner"
5-On the left side choose 4 star up option
6-From popular: Choose the Editor's choice option
7-Validate the name of product is "6-Ingredient Roasted Salmon Fillets"
8-Quit or close your driver

PURPOSE: *Apply Action class method
         *Apply How to find the unique element for real website
         *Apply JS scroll Method
         *Apply TestNG Assertion(validation)
         *Getting used to UI real interview question types
 */