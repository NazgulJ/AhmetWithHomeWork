package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class GetAttributePractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait time
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");//url
        Thread.sleep(1000);
        WebElement collapse =driver.findElement(By.xpath("//button"));
        collapse.click();
        List<WebElement> allbox=driver.findElements(By.xpath("//div[@role='checkbox']"));
        for(WebElement box: allbox){
            if(box.getAttribute("aria-checked").equals("false")){
                Thread.sleep(1000);
                box.click();

            }

        }




    }
}
