package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {

    @Test

    public void practiceMultipleWindows() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
        String mainPage = driver.getWindowHandle();
        Set<String> allPages = driver.getWindowHandles();
        for (String id : allPages) {
            if (!id.equals(mainPage)) {
                driver.switchTo().window(id);
                break;
            }
        }
        BrowserUtils.switchByTitle(driver, "Contact");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        BrowserUtils.switchByTitle(driver, "Kickstart Your Tech Career with Our Top-Rated Coding Bootcamp");
        System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver, "Courses");
        System.out.println(driver.getTitle());

    }
    @Test
    public void RealTask(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
                /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */
        WebElement button4=driver.findElement(By.cssSelector("#newTabsBtn"));//2
        BrowserUtils.scrollWithJS(driver,button4);
        button4.click();
        BrowserUtils.switchByTitle(driver,"Basic controls");
        System.out.println(driver.getTitle());
        WebElement firstName=driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.sendKeys("Nazgul");
         WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.sendKeys("Bekbolotova");
         WebElement gender= driver.findElement(By.xpath("//input[@id='femalerb']"));
gender.click();
WebElement language =driver.findElement(By.xpath("//input[@id='englishchbx']"));
language.click();
WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
email.sendKeys("fashionazi@mail.ru");
WebElement password =driver.findElement(By.xpath("/input[@id='password']"));
password.sendKeys("12345");
WebElement regist=driver.findElement(By.xpath("//button[@id='registerbtn']"));
regist.click();
WebElement message=driver.findElement(By.cssSelector("#msg"));
String actual= BrowserUtils.getText(message);
String expected="Registration is Successful";
        Assert.assertEquals(actual,expected);
BrowserUtils.switchByTitle(driver,"Window Handles");
WebElement header=driver.findElement(By.xpath("//h1"));
String actualH= BrowserUtils.getText(header);
        String expectedH="Window Handles Practice - H Y R Tutorials";
        Assert.assertEquals(actual,expected);
BrowserUtils.switchByTitle(driver,"AlertDemo");
WebElement clickme=driver.findElement(By.cssSelector("prompt"));
clickme.click();
driver.close();
driver.quit();







    }
}