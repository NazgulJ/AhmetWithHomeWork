package ActionClass;

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

public class DragAndDrop {

    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Actions actions=new Actions(driver);
        actions.scrollByAmount(200,200).perform();
        WebElement orangeBox=driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actualMessege= BrowserUtils.getText(orangeBox);
        String expectedMessege="... Or here.";
        Assert.assertEquals(actualMessege,expectedMessege);
String actualBackGroundColor=orangeBox.getCssValue("background-color");
String expectedBackGroundColor="";
Assert.assertEquals(actualBackGroundColor,expectedBackGroundColor);
WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
      //  Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.dragAndDrop(draggable,orangeBox).perform();
        Thread.sleep(2000);
        orangeBox=driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
String actualAfterDragAndDrop= BrowserUtils.getText(orangeBox);
String expectedAfterDragAndDrop="You did great!";
Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);

    }
    @Test
    public  void DragAndDropPractice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area ");
WebElement blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
String actualMeseege= BrowserUtils.getText(blueBox);
String expectMessege="Drag the small circle here ...";
Assert.assertEquals(actualMeseege,expectMessege);
String actualColor=blueBox.getCssValue("background-color").trim();
String expectedColor="rgba(63, 81, 181, 1)";
Assert.assertEquals(actualColor,expectedColor);
WebElement draggible= driver.findElement(By.xpath("//div[@id='draggable']"));
Actions actions=new Actions(driver);
actions.clickAndHold(draggible).moveToElement(blueBox).release().perform();
  blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
String actualAfterAction= BrowserUtils.getText(blueBox);
String expectAfterAction="You did great!";
Assert.assertEquals(actualAfterAction,expectAfterAction);


    }

}
