package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FramePractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");

        WebElement box=driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));

    }
    /*
TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Java" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Java Tutorial – Basic to Advance"
  5-Print out(NO validation) Table of Content options on console(loop and getText())
  6-Wait for Second task
 */
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
WebElement pavilion=driver.findElement(By.xpath("//a[.='Pavilion']"));
pavilion.click();
BrowserUtils.switchByTitle(driver,"Home - qavalidation");
WebElement seliniumButton=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions=new Actions(driver);
actions.moveToElement(seliniumButton).perform();
        WebElement javaPython=driver.findElement(By.xpath("//span[.='Selenium-Python']"));
        actions.click(javaPython).perform();
        WebElement header =driver.findElement(By.tagName("h1"));
String actual= BrowserUtils.getText(header);
String expect="Selenium-Python Tutorial";
Assert.assertEquals(actual,expect);
List<WebElement> allLinks = driver.findElements(By.xpath("//p//a"));
        for (WebElement link : allLinks){
            System.out.println(BrowserUtils.getText(link));
        }
        BrowserUtils.switchByTitle(driver,"iframes"); //this is where my driving pointing
        driver.switchTo().frame("Framename1");
        WebElement category1=driver.findElement(By.xpath(""));  //find the category 1
        category1.click();
        BrowserUtils.switchByTitle(driver,"Archives");
        WebElement headers=driver.findElement(By.tagName("h1"));
        String actual1 = BrowserUtils.getText(headers);
        String expected1="Category Archives: SeleniumTesting";
        Assert.assertEquals(actual1,expected1);
        Thread.sleep(1000);
        List<WebElement> allHeader=driver.findElements(By.xpath("//h3[@class='entry-title']"));
        for(WebElement headers1:allHeader){
            System.out.println(BrowserUtils.getText(headers));
        }
      BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Framename1");
        WebElement print=driver.findElement(By.xpath("//p[@id='frametext']"));
        System.out.println(BrowserUtils.getText(print));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
   WebElement category3=driver.findElement(By.xpath("//iframe[@id='Frame2']"));
   category3.click();
   WebElement headetValidate=driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(headetValidate));

        }
    }



