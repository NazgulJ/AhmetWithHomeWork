package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase2 {
    public static void main(String[] args) {
        /*
        Navigate to "https://www.saucedemo.com/"
Enter username "Java"
Enter password "Selenium"
Click Login button
Validate "Epic sadface: Username and password do not
match any user in this service" message
TIPS:to be able to see this message you need to first see this
message then try to inspect it. (it means at least run one time
with the username and password you provided above to see
the message then inspect the message.*be careful with it is
fully copied or not.
Steps
         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("Java");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Selenium");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actualError = error.getText().trim();
        String expect = "Epic sadface: Username and password do not match any user in this service";
        System.out.println(actualError.equals(expect) ? "passed epic" : "failed epic");
    }
}
