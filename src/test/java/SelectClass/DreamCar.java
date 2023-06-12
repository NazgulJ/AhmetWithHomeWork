package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
  */
    @Test
    public  void HeadersOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/"); //1

        WebElement newUsed=driver.findElement(By.xpath("//select[@class='sds-text-field']"));
        BrowserUtils.selectBy(newUsed,"new","value");

        WebElement lexus=driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(lexus,"lexus","value");

        WebElement model=driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(model,"lexus-rx-350","value");

        WebElement price=driver.findElement(By.xpath("//select[@class='sds-text-field']"));
        Select priceM = new Select(price);
        String actual = BrowserUtils.getText(priceM.getFirstSelectedOption());
        String exp = "No max price";
        Assert.assertEquals(actual, exp);

        WebElement mile=driver.findElement(By.xpath("make-model-maximum-distance"));
        BrowserUtils.selectBy(mile,"40","text");

        WebElement zipCode=driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60056");

        WebElement searchButton=driver.findElement(By.xpath("//button[@data-linkname='search-new-make"));
        searchButton.click();

        WebElement header=driver.findElement(By.xpath("//h1@data-qa='page_h1']"));
        String actHeader= BrowserUtils.getText(header).trim();
        String expectedHeader="";
        Assert.assertEquals(actHeader,expectedHeader);
        WebElement sort=driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(sort,"Lower price","text");
        Thread.sleep(1000);
        List<WebElement> allTitles=driver.findElements(By.xpath(""));
        for (WebElement title:allTitles) {
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(title));
        }
        List<WebElement>allPrices= driver.findElements(By.cssSelector(".primary-price"));
        List<Integer>actualPrice=new ArrayList<>();
        List<Integer>expectedPrice=new ArrayList<>();
        for(int i=0;i<allPrices.size();i++){
         //  actualPrice.add(Integer.parseInt(BrowseUtils.getText(actualPrice.get(i)).replace("$","").replace(",","")));
         //  expectedPrice.add(Integer.parseInt(BrowseUtils.getText(actualPrice.get(i)).replace("$","").replace(",","")));
        }
        Collections.sort(expectedPrice);
        Assert.assertEquals(actualPrice,expectedPrice);
        System.out.println(actualPrice);
        System.out.println(expectedPrice);
    }
}
