package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void AlertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(" https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert=driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        jsAlert.click();
        Alert alert=driver.switchTo().alert();
        String actuslText=alert.getText().trim(); // will get the text from pop-up that i can not inspect
        String expectedText="I am a JS Alert";
        Assert.assertEquals(actuslText,expectedText);
        alert.accept(); // will click OK button , otherwise you will get INHANDLE ALERT EXCEPTION
        WebElement message =driver.findElement(By.cssSelector("#result"));
        String actualMess= BrowserUtils.getText(message); // this is come from website
        String expectedMess="You successfully clicked an alert";
        Assert.assertEquals(actualMess,expectedMess);

    }
    @Test
    public  void AlertDismiss(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(" https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConform= driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        jsConform.click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
WebElement jsPrompt=driver.findElement(By.xpath("//p[contains(@id,'result')]"));
String actualMessege= BrowserUtils.getText(jsPrompt);
String expectedMessege="You clicked: Cancel ";
Assert.assertEquals(actualMessege,expectedMessege);

    }
    @Test
    public void sendKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(" https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPompt= driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPompt.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Homework is Important");
        Thread.sleep(1000);
        alert.accept();
        WebElement message =driver.findElement(By.cssSelector("#result"));
        String actmess= BrowserUtils.getText(message);
        String expMes="You entered: Homework is Important ";
        Assert.assertEquals(actmess,expMes);

    }
}
