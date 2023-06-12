package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase3 {
    public static void main(String[] args) {
        /*
        Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Validate current url is
"https://www.saucedemo.com/inventory.html"
Steps
         */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement userName=driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password =driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement button=driver.findElement(By.name("login-button"));
        button.click();
        String currectUrl =driver.getCurrentUrl();
        String expectUrl="https://www.saucedemo.com/inventory.html";
        System.out.println(currectUrl.equals(expectUrl) ? "Passed Url":"Failed Url");
       // driver.close();
    }
}
