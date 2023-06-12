package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementsPractice {
    public static void main(String[] args) throws InterruptedException {
        /*
        //task2
    //print it of lenght is equel and more than 12 and count how many

         */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait time
        driver.get("https://the-internet.herokuapp.com/"); //url
        Thread.sleep(1000);
        List<WebElement> allLinks = driver.findElements(By.xpath("//li"));
        int count2 = 0;
        for (WebElement link : allLinks) {
            if (link.getText().length() >= 12) {
                System.out.println(link.getText().trim());
                count2++;
            }
        }
        System.out.println(count2);
    }
}

