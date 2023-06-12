package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CSSLocator {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(new ChromeOptions());
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        WebElement searchBar=driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        searchBar.sendKeys("Watch");
        WebElement searchbutton=driver.findElement(By.cssSelector(".wt-input"));
        searchbutton.click();
        System.out.println(driver.getCurrentUrl());












    }
}
