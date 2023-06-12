package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocaterIntro2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/nazgul/Desktop/Techtorial.html");

    //LINKTEXT LOCATION

        WebElement javaLink=driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String actualHeader = javaHeader.getText().trim();
        String expectedHeader="Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "CORRECT" : " FALSE");

        driver.navigate().back();
        WebElement selenium=driver.findElement(By.linkText("Selenium"));
        selenium.click();
        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        String actualSeleniumHeader2 = seleniumHeader.getText().trim();
        String expectedHeader2="Selenium automates browsers. That's it!";
        System.out.println(actualSeleniumHeader2.equals(expectedHeader2) ? "PASSED" : "FAILED SELENIUM");
        driver.navigate().back();

        WebElement cucumberLink=driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement cucumberHeader=driver.findElement(By.tagName("h1"));
        String actcucumberHeader= cucumberHeader.getText().trim();
        String expectedcucumberHeader="Tools & techniques that elevate teams to greatness";
        System.out.println(actcucumberHeader.equals(expectedcucumberHeader) ? "Passed Cucumber" : "Failed Cucumber");
        driver.navigate().back();

        WebElement testNGLink = driver.findElement(By.linkText("TestNG"));
        testNGLink.click();
        WebElement headerTestNG= driver.findElement(By.tagName("h2"));
        String actualTestHeader =headerTestNG.getText();
        String expectedTestH="TestNG";
        System.out.println(actualTestHeader.equals(expectedTestH) ? "Passed" : "Failed");
        driver.navigate().back();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="file:///Users/nazgul/Desktop/Techtorial.html";
        System.out.println(actualUrl.equals(expectedUrl) ? "Passed" : "Failed");
        javaLink=driver.findElement(By.linkText("Java"));
        javaLink.click();
        driver.navigate().back();


        //LOCATOR PARTIALLINKTEXT:

        WebElement restApi =driver.findElement(By.partialLinkText("Res"));
        restApi.click();
        System.out.println(driver.getTitle());





















    }
}
