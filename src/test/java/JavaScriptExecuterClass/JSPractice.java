package JavaScriptExecuterClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class JSPractice {
    @Test
    public void JSPractice() throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("https://demoqa.com/radio-button");

            WebElement yes=driver.findElement(By.xpath("//label[@for='yesRadio']"));
            yes.click();
            WebElement actualMess=driver.findElement(By.xpath("//label[@for='yesRadio']"));
            String expectedMess="yes";
            Assert.assertEquals(BrowserUtils.getText(actualMess),expectedMess);
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].click()",yes);
            Thread.sleep(1000);

            WebElement imressive=driver.findElement(By.cssSelector("mb-3" ));
            imressive.click();
            String actualMessege= BrowserUtils.getText(imressive);
            String expectedMessege="Impressive";
            Assert.assertEquals(actualMessege,expectedMessege);

            WebElement actual=driver.findElement(By.xpath("//label[@for='noRadio']"));
            String expected="no";
         //   Assert.assertFalse((actual.isEnabled());

    }
@Test
        public  void Practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement copyRight = driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        //System.out.println(copyRight.getText().trim());
        BrowserUtils.scrollWithJS(driver,copyRight);
        //VALIDATE
        String actualText = BrowserUtils.getText(copyRight);
        String expectedText = "Copyright © 2023";
        Assert.assertEquals(actualText,expectedText);

        WebElement applyNow = driver.findElement(By.linkText("Apply Now"));
        Thread.sleep(1000);
        WebElement tech= driver.findElement(By.xpath("//b[.='LAUNCH A NEW TECH CAREER']"));
        BrowserUtils.scrollWithJS(driver,tech);
        Thread.sleep(1000);
        BrowserUtils.scrollWithJS(driver,applyNow);
        Thread.sleep(1000);
        BrowserUtils.clickWithJS(driver,applyNow);
        Thread.sleep(1000);
        String actualTitle = BrowserUtils.getTitleWithJS(driver);
        String expectedTitle ="Apply Now";
        Assert.assertEquals(actualTitle,expectedTitle);
        List<WebElement> allInformation= driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedInfromation = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

        for (int i=0;i<allInformation.size();i++){
                Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedInfromation.get(i));
        }
    }
}


