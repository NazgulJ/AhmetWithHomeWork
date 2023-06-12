package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorPractice {
    /*
        /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url c
10-Close the webpage
Try your own logic and automate it without any help.
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(new ChromeOptions());
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Nazgul");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Bekbolotova");
        WebElement gender = driver.findElement(By.id("sex-1"));
        Thread.sleep(2000);
        gender.click();
        WebElement experience =driver.findElement(By.id("exp-1"));
        experience.click();
        WebElement data = driver.findElement(By.id("datepicker"));
        data.sendKeys("09/12/22");
        WebElement profession = driver.findElement(By.id("profession-0"));
        Thread.sleep(2000);
        profession.click();
        WebElement tools = driver.findElement(By.id("tool-2"));
        Thread.sleep(2000);
        tools.click();
        WebElement continent = driver.findElement(By.id("continents"));
        continent.sendKeys("Asia");
        WebElement selenium =driver.findElement(By.id("Browser Commands"));
        selenium.sendKeys("Java");
        WebElement botton = driver.findElement(By.id("submit"));
        Thread.sleep(2000);
        botton.click();
        String actUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.techlistic.com/p/selenium-practice-form.html";
        System.out.println(actUrl.equals(expectedUrl) ? "PASSED" : "FAILED");
        driver.close();

    }
}
