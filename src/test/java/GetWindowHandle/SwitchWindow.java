package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test

    public void switchPractice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header).trim());
        System.out.println(driver.getWindowHandle()); // this will return id of the finger //main pageID-The internet
       String mainPageId=driver.getWindowHandle();
        Set<String> allPagesId= driver.getWindowHandles();
        for(String id: allPagesId){
            if(!id.equals(mainPageId)){
               driver.switchTo().window(id);
                break;
            }
           // System.out.println(chromeDriver.getWindowHandle());//second will be print
        }
        header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }
    @Test
    public void Practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver= new ChromeDriver(chromeOptions);
   driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
WebElement button2=driver.findElement(By.cssSelector("#newTabBtn"));
button2.click();
        String mainPage=driver.getWindowHandle(); //this is my currect driver page id
        Set<String>allPages=driver.getWindowHandles();//all pages (include the second page)
        for(String id:allPages) {
            if (!id.equals(allPages)) {
                driver.switchTo().window(id);
                break;
            }
        }
String actualTitle= driver.getTitle().trim();
String expecteD="AlertsDemo - H Y R Tutorials";
Assert.assertEquals(actualTitle,expecteD);
WebElement header=driver.findElement(By.xpath("//h1[@itemprop='name']"));
String actualHeader= BrowserUtils.getText(header);
String expected="AlertsDemo";
Assert.assertEquals(actualHeader,expected);
WebElement alertBox=driver.findElement(By.cssSelector("#alertBox"));
alertBox.click();


    }
    }

