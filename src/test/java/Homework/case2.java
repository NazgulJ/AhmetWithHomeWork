package Homework;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class case2 {
    @Test
    public void practice(){
        /*

"http://secure.smartbearsoftware.com/samples/TestCo
mplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "View all products" button
Validate "View all products" is selected
Validate header is equals to "List of Products"
Validate the url has "Products" keyword
         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get(" http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        WebElement username=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        WebElement viewAllProducts=driver.findElement(By.linkText("View all products"));
        viewAllProducts.click();
        WebElement viewValidate=driver.findElement(By.xpath("//h2"));
        String actualValid= BrowserUtils.getText(viewValidate);
        String expectedValid="List of Products";
        Assert.assertEquals(actualValid,expectedValid);
        WebElement header=driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(BrowserUtils.getText(header),"List of Products");
        System.out.println(driver.getCurrentUrl());
        String url=driver.getCurrentUrl();
        System.out.println(url.contains("Products")? "Url is pass" : "Url failed");
    }

}
