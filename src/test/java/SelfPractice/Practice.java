package SelfPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practice {
    public static void main(String[] args) {
            /*
1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
2-Go back to the main page
3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
4-Go back to the main page
5-Click TestNG and validate(ternary) header -->TestNG
6-Go back to the main page
7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
 */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/nazgul/Desktop/Techtorial.html");

       WebElement header= driver.findElement(By.linkText("Selenium"));//<a+link we choose linktext
       header.click();
       WebElement headerSelenium= driver.findElement(By.tagName("h1")); //h1, h5, dev - tag tagName
        String actualHeader =headerSelenium.getText().trim();
       String expected="Selenium automates browsers. That's it!"; // validate... u have to create expected headerSystem.out.println(headerSelenium.equals(expected) ? "Passed" : "Failed"); // here we do validation, = comparing actual with expected
        driver.navigate().back();// in description it told us to go back.. this is a command to go back to the previous page





    }
}
