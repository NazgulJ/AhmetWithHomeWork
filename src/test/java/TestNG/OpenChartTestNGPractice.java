package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(" https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button")); // tagName -->"button"
        login.click();
        Thread.sleep(1000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        Thread.sleep(1000);
        String actualTitle = driver.getTitle();
        String expextTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expextTitle);
        driver.quit();
    }

    @Test
    public void negative() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options1 = new ChromeOptions();
        options1.addArguments("--remote-allow-origins=*");
        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver1.navigate().to(" https://demo.opencart.com/admin/");
        WebElement username1 = driver1.findElement(By.xpath("//input[@id='input-username']"));
        username1.sendKeys("demo");
        WebElement password1 = driver1.findElement(By.xpath("//input[@id='input-password']"));
        password1.sendKeys("123");
        WebElement login1 = driver1.findElement(By.xpath("//button")); // tagName -->"button"
        login1.click();
        Thread.sleep(1000);
        WebElement errorMess = driver1.findElement(By.cssSelector("#alert"));
        String actualMess = errorMess.getText().trim();
        String expectMess = "";
        //Assert.assertEquals();
    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(" https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button")); // tagName -->"button"
        login.click();
        Thread.sleep(1000);
        WebElement XButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        XButton.click();
        Thread.sleep(1000);
        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(1000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productButton.isDisplayed());
        Assert.assertTrue(productButton.isEnabled());
    }

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(" https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button")); // tagName -->"button"
        login.click();
        Thread.sleep(1000);
        WebElement XButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        XButton.click();
        Thread.sleep(1000);
        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(1000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        List<WebElement> allBoxses = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 0; i < allBoxses.size(); i++) {
            Thread.sleep(1000);
            Assert.assertTrue(allBoxses.get(i).isDisplayed());
            Assert.assertTrue(allBoxses.get(i).isEnabled());
            Assert.assertFalse(allBoxses.get(i).isSelected()); //as default it should not be selected
            allBoxses.get(i).click();
            Assert.assertTrue(allBoxses.get(i).isSelected());//this one is Selected
            allBoxses.get(i).sendKeys(Keys.ARROW_DOWN);
        }
    }

    /*
            TEST CASE:
            1 you will click the productName button
            2 you should create 2 arrayList
            *One of them will actualData
            *Another will be expectedData
            3 For(int i=1)
            *store all the name for both of the list
            4 For expected List-> you will use Collections.sort(expectedList)
            --> Collections.reverse(expected)
            Assert.equals(actualList,expectedList)
             */
    @Test
    public void validateBoxesFunctionalAssendingOrder() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(" https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button")); // tagName -->"button"
        login.click();
        Thread.sleep(1000);
        WebElement XButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        XButton.click();
        Thread.sleep(1000);
        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(1000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        Thread.sleep(3000);

        List<WebElement> allListA = driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualProductName = new ArrayList<>();
        List<String> expectedProdectOrder = new ArrayList<>();

        for (int i = 1; i < allListA.size(); i++) {  //3
            actualProductName.add(allListA.get(i).getText().toLowerCase().trim());
            expectedProdectOrder.add(allListA.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expectedProdectOrder);
        System.out.println(actualProductName);
        System.out.println(expectedProdectOrder);

        Assert.assertEquals(actualProductName, expectedProdectOrder);
    }
    @Test
    public  void validateDescendingOrder() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(" https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button")); // tagName -->"button"
        login.click();
        Thread.sleep(1000);
        WebElement XButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        XButton.click();
        Thread.sleep(1000);
        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(1000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        WebElement productName=driver.findElement(By.xpath("//a[.='Product Name']"));
        productName.click();
        Thread.sleep(3000);
        List<WebElement> allListA = driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualProductName = new ArrayList<>();
        List<String> expectedProdectOrder = new ArrayList<>();
        for (int i = 1; i < allListA.size(); i++) {  //3
            actualProductName.add(allListA.get(i).getText().toLowerCase().trim());
            expectedProdectOrder.add(allListA.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expectedProdectOrder);
        Collections.reverse(expectedProdectOrder);
        System.out.println(actualProductName);
        System.out.println(expectedProdectOrder);

        Assert.assertEquals(actualProductName, expectedProdectOrder);
    }
}
/*
 TEST CASE:
            1 you will click the productName button
            2 you should create 2 arrayList
            *One of them will actualData
            *Another will be expectedData
            3 For(int i=1)
            *store all the name for both of the list
            4 For expected List-> you will use Collections.sort(expectedList)
            --> Collections.reverse(expected)
            Assert.equals(actualList,expectedList)
 */

