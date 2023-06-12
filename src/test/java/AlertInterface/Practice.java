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

public class Practice {
    @Test
    public void Practice() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement alertBox=driver.findElement(By.xpath("//button[@id='alertBox']"));
        alertBox.click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        WebElement clickMe=driver.findElement(By.xpath("//button[@id='confirmBox']"));
        clickMe.click();
        WebElement cancel=driver.findElement(By.xpath("//p[contains(@id,'result')]"));
        cancel.click();
        alert.dismiss();
        System.out.println(BrowserUtils.getText(clickMe));

        WebElement promptBox=driver.findElement(By.xpath("//button[@id='promptBox']"));
        promptBox.click();
        alert.sendKeys("Nazgul");
        alert.accept();
        String actualT= BrowserUtils.getText(alertBox);
        String expectedT="You entered: name Nazgul in prompt popup";
        Assert.assertEquals(actualT,expectedT);

//        WebElement boxOutput=driver.findElement(By.xpath("//div[@id='output']"));
//        System.out.println(BrowseUtils.getText(boxOutput));
//        boxOutput.click();
    }
}