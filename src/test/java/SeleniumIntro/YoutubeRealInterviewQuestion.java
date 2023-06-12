package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class YoutubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait time
        driver.get("https://www.youtube.com/");
        Thread.sleep(1000);
        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("zivert");
        Thread.sleep(2000);
        WebElement searchButton = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        searchButton.click();
        Thread.sleep(1000);
        List<WebElement> songName = driver.findElements(By.xpath("//a[@id='video-title']"));

        for (WebElement song : songName) {
            if (song.getAttribute("aria-label").equals("Zivert - Life | Премьера клипа by Zivert 4 years ago 3 minutes, 31 seconds 153,462,219 views"))
                ;
            Thread.sleep(2000);
            song.sendKeys(Keys.ARROW_DOWN);
            song.click();
            break;
        }
    }

}

