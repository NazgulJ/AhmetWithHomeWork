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

public class PracticeAction {

    @Test
    public void practiceDragAndDrop(){  //DradAndDrop
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");

        WebElement dropBox=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualMess= BrowserUtils.getText(dropBox);
        String expecteMess="Drop here";
        Assert.assertEquals(actualMess,expecteMess);

       WebElement dragMe=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragMe,dropBox).perform();
        dropBox=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
String actualAfterDropAndDrop= BrowserUtils.getText(dropBox);
String expectedAfterDropAndDrop="Dropped!";
Assert.assertEquals(actualAfterDropAndDrop,expectedAfterDropAndDrop);
String actualColor=dropBox.getCssValue("background-color");
String expectColor="rgba(70, 130, 180, 1)";
Assert.assertEquals(actualColor, expectColor);
    }
    @Test
    public void practiceClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement acceptButton=driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        acceptButton.click();
        Thread.sleep(2000);
        WebElement notAcceptable=driver.findElement(By.xpath("//div[@id='notAcceptable']"));
String actualText= BrowserUtils.getText(notAcceptable);
String expectText="Not Acceptable";
Assert.assertEquals(actualText,expectText);
Thread.sleep(2000);
WebElement box= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
String actMes= BrowserUtils.getText(box);
String expMes="Drop here";
Assert.assertEquals(actMes,expMes);
Assert.assertEquals(actualText,expectText);
Actions actions=new Actions(driver);
actions.clickAndHold(notAcceptable).moveToElement(box).perform();
String actualMessegeAfterAction= BrowserUtils.getText(box);
String expectedMessegeAfterAction="Drop here";
Assert.assertEquals(actualMessegeAfterAction,expectedMessegeAfterAction);

    }
}
