package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrame {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");

        //Name or ID iframe
        driver.switchTo().frame("frame-top");

        //Webelement iframe
        WebElement iframeLeft=driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(iframeLeft);
        WebElement left=driver.findElement(By.xpath("//body[contains(text(),'LEFT']"));
        System.out.println(BrowserUtils.getText(left));
        driver.switchTo().parentFrame();//top frame
        driver.switchTo().frame("frame-middle"); //middle frame
        WebElement middle =driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        System.out.println(BrowserUtils.getText(middle));
        driver.switchTo().parentFrame(); //top frame
        driver.switchTo().frame("frame-right");//right frame
        WebElement right =driver.findElement(By.xpath("//body[contains(text(),'RIGHT']"));
        System.out.println(BrowserUtils.getText(right));
//Can you print out Bottom
//        driver.switchTo().parentFrame(); //TOP FRAME
//        driver.switchTo().parentFrame(); // MAIN HTML

        driver.switchTo().defaultContent(); //this will main html no matter what , this is short cut
        //SWITHING FRAME WITH INDEXING
        driver.switchTo().frame("frame-botton"); //bottom
        WebElement bottomX=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottomX));


    }

}







