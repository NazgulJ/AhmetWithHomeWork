package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class homeWork2 {
    public static void main(String[] args) {
        /*
        Hello everyone, I see the excitement on your face and asking me to give you homework for tomorrow through DM. Here is the TASK:
1-Create a homework package and class
2-Under 1 main method--> go to 3 different websites and validate the title, and URL of the page with Ternary Operator. (It can be any website you decide)
SIDE NOTE: You do not need to create 3 different web drivers. One will be enough.
                     Send your code screenshot by replaying this thread.
 */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.zara.com/");
        System.out.println(driver.getTitle());
        String actualTitle= driver.getTitle();
        String expectedTitle = "ZARA Official Website";
        System.out.println( actualTitle.equals(expectedTitle) ? "Zara title Passed" : "zara title Fail");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.zara.com/";
        System.out.println( actualUrl.equals(expectedUrl) ? "Passed" : "Fail");
        driver.close();

        driver=new ChromeDriver(options);
        driver.get("https://www.wholefoodsmarket.com/");
        String actualTitle1=driver.getTitle();
        //System.out.println(driver.getTitle());
        String expectedTitle1="Whole Foods Market | Whatever Makes You Whole";
        System.out.println(actualTitle1.equals(expectedTitle1)? "Passed for WF" : "Failed for WF");
        String actualUrl1=driver.getCurrentUrl();
        String expectedUrl1="https://www.wholefoodsmarket.com/";
        System.out.println(actualUrl1.equals(expectedUrl1) ? "Passed" : "Fail");
        driver.close();

        driver =new ChromeDriver(options);
        driver.get("https://www.americantours.com/ati/");
        String americanTitle=driver.getTitle();
        //System.out.println(driver.getTitle());
        String americanETitle="Home | ATI";
        System.out.println(americanTitle.equals(americanETitle) ? "Passed" : "Failed");
        String americanUrl=(driver.getCurrentUrl());
        String americanEUrl="https://www.americantours.com/ati/";
        System.out.println(americanUrl.equals(americanEUrl) ? "Passed" : "Failed");
        driver.quit();

    }
}
