package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {

    @Test
    public void practice1(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com");
WebElement fileupload= driver.findElement(By.xpath(""));
        WebElement chooseFile=driver.findElement(By.cssSelector("#File Upload"));
        chooseFile.sendKeys("/Users/nazgul/Desktop/usa.png");
       // Assert.assertTrue(BrowserUtils.getText(chooseFile).contains("usa.png"));
        WebElement uploadBut= driver.findElement(By.cssSelector("#file-submit"));
        uploadBut.submit();
       // uploadBut.click();
        WebElement validateFileName=driver.findElement(By.cssSelector("#uploaded-file"));
       String actual=BrowserUtils.getText(validateFileName);
       String extected="usa.png";
       Assert.assertEquals(actual,extected);
    }
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        WebElement chooseFile= driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
        chooseFile.sendKeys("/Users/nazgul/Desktop/usa.png");
        Thread.sleep(2000);
        WebElement selectMax= driver.findElement(By.xpath("//b[contains(text(),'Select file to send(max 196.45 MB')]"));
        String actualM=BrowserUtils.getText(selectMax);
        String expected="Select file to send(max 196.45 MB)";
        Assert.assertEquals(actualM,expected);
        WebElement accept= driver.findElement(By.xpath("//input[@id='terms']"));
        accept.click();
        WebElement submitFile=driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitFile.click();
        Thread.sleep(3000);
        WebElement messege= driver.findElement(By.xpath("//h3[@id='res']"));
        String actualMessege=BrowserUtils.getText(messege);
        String expectedMessge="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualMessege,expectedMessge);
    }
}
