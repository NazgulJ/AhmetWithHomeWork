package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class case3 {
    /*
     to
"http://secure.smartbearsoftware.com/sample
s/TestComplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Find the links for
View all orders
View all products
Orders
Validate their href values are equals to :
"Default.aspx"
"Products.aspx"
"Process.aspx"
     */
    @Test
    public  void practice(){
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
        WebElement allLink=driver.findElement(By.linkText("View all orders"));
        WebElement orders=driver.findElement(By.linkText("Order"));
        WebElement products=driver.findElement(By.linkText("View all products"));
        System.out.println( orders.getAttribute("href"));
        System.out.println(allLink.getAttribute("href"));
        System.out.println(products.getAttribute("href"));

        Assert.assertTrue(orders.getAttribute("href").contains("Process.aspx"));
        Assert.assertTrue(allLink.getAttribute("href").contains("Default.aspx"));
        Assert.assertTrue(products.getAttribute("href").contains("Products.aspx"));
    }
}
