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

public class HTMLAndJSPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");
        WebElement preview= driver.findElement(By.xpath("//button[@class='preview']"));
        preview.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        WebElement previewButton =driver.findElement(By.xpath("//button[@class='preview']"));
        System.out.println(BrowserUtils.getText(previewButton));
        previewButton.click();
        Thread.sleep(2000);
        alert.accept();
        WebElement messege= driver.findElement(By.xpath("//button[contains(@onclick, 'error')]"));
        System.out.println(BrowserUtils.getText(messege));
        String actualMess= BrowserUtils.getText(messege);
        String expectedMess="Something went wrong!";
        Assert.assertTrue(actualMess.contains(expectedMess));
        //all text with OK as well
        messege.click();
        Thread.sleep(2000);
        WebElement ok =driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        ok.click();
        driver.quit();



    }
}
