package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        Thread.sleep(2000);
        WebElement makeAppoitment=driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppoitment.click();
        WebElement userName= driver.findElement(By.xpath("//input[@value='John Doe']"));
        System.out.println(userName.getText());
        System.out.println(userName.getAttribute("value"));//John Doe
        System.out.println(userName.getAttribute("type"));//text
        driver.quit();
    }
}
