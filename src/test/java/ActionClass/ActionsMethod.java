package ActionClass;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsMethod {

    @Test   //right click
    public void contextClick() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu ");
        WebElement box= driver.findElement(By.xpath("//div[@class='example']//div[@id='hot-spot']"));
      Actions actions=new Actions(driver);
      actions.contextClick(box).perform(); // do not forget put perform()
    }
@Test
    public void practiceContextClick(){
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.navigate().to(" https://demo.guru99.com/test/simple_context_menu.html");
    WebElement rightClick=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
    Actions actions=new Actions(driver);  //
    actions.contextClick(rightClick).perform();

}
@Test
    public  void doubleClick(){
//
//    WebElement doubleClick=driveWebDriverManage.chromedriver().setup();
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--remote-allow-origins=*");
//    WebDriver driver = new ChromeDriver();
//    driver.manage().window().maximize();
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    driver.navigate().to(" https://demo.guru99.com/test/simple_context_menu.html");
//    Actions action= new Actions(driver);
//    action.doubleClick(doubleClick).perform();

}

}






















