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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class case1 {

    @Test
    public void practice(){
        /*
        Navigate to
"http://secure.smartbearsoftware.com/samples/Te
stComplete11/WebOrders/Login.aspx?"
Validate the title is equals to "Web Orders Login"
Input username "Tester"
Input password "test"
Click login button
Validate the title is equals to "Web Orders"
Validate header is equals to "List of All Orders"
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
        WebElement title=driver.findElement(By.tagName("h1"));
        String actualTitle= BrowserUtils.getText(title);
        String expectedTitle="Web Orders";
        Assert.assertEquals(actualTitle,expectedTitle);
        WebElement header=driver.findElement(By.xpath("//h2"));
        String actualHeader= BrowserUtils.getText(header);
        String expectedHeader="List of All Orders";
        Assert.assertEquals(actualHeader,expectedHeader);
        driver.quit();
    }
    @Test
    public void practice2(){
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

    @Test
    public  void practice3(){
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
    @Test
    public void practice4() throws InterruptedException {
        /*
        "http://secure.smartbearsoftware.com/samples/TestComplete11
/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "Order" button
Select product "Screen Saver"
Input quantity 5
Input Customer name "CodeFish IT School"
Input Street "2200 E devon"
Input City "Des Plaines"
Input State "Illinois"
Input Zip "60018"
Select MasterCard
Input card number "444993876233"
Input expiration date "03/24"
Click Process button
         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get(" http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        WebElement orders = driver.findElement(By.linkText("Order"));
        orders.click();
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        BrowserUtils.selectBy(product, "ScreenSaver", "value");
        WebElement quatity=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quatity.sendKeys("5");
        WebElement customer=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customer.sendKeys("CodeFish IT School");
        WebElement street=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        street.sendKeys("2200 E devon");
        WebElement city=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");
        WebElement state=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys("Illinois");
        WebElement zipCode=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipCode.sendKeys("60018");
        WebElement creditCard=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        creditCard.click();
        WebElement cardNumber=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys("444993876233");
        WebElement expirationDate=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expirationDate.sendKeys("03/24");
        Thread.sleep(2000);
        WebElement process=driver.findElement(By.linkText("Process"));
        process.click();
        Thread.sleep(2000);
        driver.quit();
    }

    /*
    Validate text "New order has been successfully
added." is displayed below the Process button.
Click View all orders button
Validate new order is added and all inputs are
matching with new order
     */
    @Test
    public void practice5() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get(" http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        WebElement orders = driver.findElement(By.linkText("Order"));
        orders.click();
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        BrowserUtils.selectBy(product, "ScreenSaver", "value");
        WebElement quatity=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quatity.sendKeys("5");
        WebElement customer=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customer.sendKeys("CodeFish IT School");
        WebElement street=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        street.sendKeys("2200 E devon");
        WebElement city=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");
        WebElement state=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys("Illinois");
        WebElement zipCode=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipCode.sendKeys("60018");
        WebElement creditCard=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        creditCard.click();
        WebElement cardNumber=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys("444993876233");
        WebElement expirationDate=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expirationDate.sendKeys("03/24");
        Thread.sleep(2000);
        WebElement process=driver.findElement(By.linkText("Process"));
        process.click();
        Thread.sleep(2000);
        WebElement validateText=driver.findElement(By.xpath("//strong"));
        BrowserUtils.getText(validateText);
        Assert.assertTrue(validateText.isDisplayed());
        WebElement allOrder=driver.findElement(By.linkText("View all orders"));
        allOrder.click();////input[@type='checkbox']

        List<WebElement> allOrders=driver.findElements(By.xpath("//tr[2]//td"));
        List<String> actual = new ArrayList<>();
        List<String> expected= Arrays.asList("CodeFish IT School","ScreenSaver","5","06/03/2023","2200 E devon",
                "Des Plaines","Illinois","60018","MasterCard","444993876233","03/24");

        for(int i=1; i<actual.size();i++){
            actual.add(allOrders.get(i).getText());
            if(allOrders.get(i).getText().equals("3/24")){
                break;
            }
            System.out.println(actual);
            Assert.assertEquals(actual,expected);
        }
    }

}






