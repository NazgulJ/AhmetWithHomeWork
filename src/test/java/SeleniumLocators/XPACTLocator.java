package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPACTLocator {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement abTesting =driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]")); //
        abTesting.click();
        //ABSOLUTE XPATH
        WebElement header=driver.findElement(By.xpath(""));
        System.out.println(header.getText());
        WebElement paragraph =driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));// this is absolut
        System.out.println(paragraph.getText());
        WebElement selenium=driver.findElement(By.xpath(" //a[contains(text),'Element Selenium')]"));
        selenium.click();








    }
}
