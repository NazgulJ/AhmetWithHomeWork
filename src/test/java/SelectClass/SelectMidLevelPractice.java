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
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPractice {
    /*
    1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
     */

    @Test
    public  void validateOrderMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(" https://demo.guru99.com/test/newtours/reservation.php "); //1
        WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']")); //2
        oneWay.click();
        Thread.sleep(1000);

        WebElement passengerNumber = driver.findElement(By.xpath("//select[@name='passCount']")); //3
        Select passenger = new Select(passengerNumber);
        passenger.selectByIndex(3);
        Thread.sleep(1000);

        WebElement fromPort = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select fPort = new Select(fromPort);
        String actual = fPort.getFirstSelectedOption().getText().trim();
        String exp = "Acapulco";
        Assert.assertEquals(actual, exp);

        WebElement departing = driver.findElement(By.xpath("//select[@name='fromPort']")); //4
        Select departingFrom = new Select(departing);
        departingFrom.selectByVisibleText("Paris");
        Thread.sleep(1000);

        WebElement on = departing.findElement(By.xpath("//select[@name='fromMonth']"));
        Select month = new Select(on);
        month.selectByVisibleText("August");

        WebElement onDataFly = departing.findElement(By.xpath("//select[@name='fromDay']"));
        Select data = new Select(onDataFly);
        data.selectByIndex(14);

        WebElement returning = departing.findElement(By.xpath("//select[@name='toMonth']")); //5
        Select returningTo = new Select(returning);
        returningTo.selectByVisibleText("December");
        Thread.sleep(1000);

        WebElement date = departing.findElement(By.xpath("//select[@name='toDay']")); //6
        Select dataT = new Select(date);
        dataT.selectByIndex(14);
        Thread.sleep(1000);

        WebElement arrivingIn = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arriving = new Select(arrivingIn);
        arriving.selectByVisibleText("San Francisco");

        WebElement selectService = driver.findElement(By.xpath("//input[@value='First']"));
        selectService.click();
        Thread.sleep(1000);

        WebElement airloine = date.findElement(By.xpath("//select[@name='airline']"));
        Select arline = new Select(airloine);
        List<WebElement> allOptions = arline.getOptions();
        List<String> expOption = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

       for (int i = 0; i < allOptions.size(); i++) ;
     //  Assert.assertEquals(allOptions.get(i).getText().trim(), expOption.get(i));

       WebElement continueButton=date.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();

WebElement messageOnTheTop =date.findElement(By.xpath("//font[@size='4']"));
Assert.assertEquals(BrowserUtils.getText(messageOnTheTop),"        After flight finder - No Seats Avaialble  ");
    }


    @Test
    public  void validateOrderMessageA() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(" https://demo.guru99.com/test/newtours/reservation.php "); //1

        WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']")); //2
        oneWay.click();
        Thread.sleep(1000);

        WebElement passengerNumber = driver.findElement(By.xpath("//select[@name='passCount']")); //3
        Thread.sleep(1000);
        BrowserUtils.selectBy(passengerNumber, "4", "value");
        WebElement fromPort = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select fPort = new Select(fromPort);
        String actual = fPort.getFirstSelectedOption().getText().trim();
        String exp = "Acapulco";
        Assert.assertEquals(actual, exp);

        WebElement departing = driver.findElement(By.xpath("//select[@name='fromPort']")); //4
        Thread.sleep(1000);
        BrowserUtils.selectBy(departing, "Paris", "text");

        WebElement on = departing.findElement(By.xpath("//select[@name='fromMonth']"));
        Select month = new Select(on);
        month.selectByVisibleText("August");

        WebElement onDataFly = departing.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(onDataFly, "7", "Index");

        WebElement returning = departing.findElement(By.xpath("//select[@name='toMonth']")); //5
        Select returningTo = new Select(returning);
        returningTo.selectByVisibleText("December");
        Thread.sleep(1000);

        WebElement date = departing.findElement(By.xpath("//select[@name='toDay']")); //6
        Select dataT = new Select(date);
        dataT.selectByIndex(14);
        Thread.sleep(1000);

        WebElement arrivingIn = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(arrivingIn, "San Francisco", "text");

        WebElement selectService = driver.findElement(By.xpath("//input[@value='First']"));
        selectService.click();
        Thread.sleep(1000);

        WebElement airloine = date.findElement(By.xpath("//select[@name='airline']"));
        Select arline = new Select(airloine);
        List<WebElement> allOptions = arline.getOptions();
        List<String> expOption = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

        for (int i = 0; i < allOptions.size(); i++) {
            Thread.sleep(1000);
            Assert.assertEquals(BrowserUtils.getText(allOptions.get(i)), expOption.get(i).trim());
        }
        WebElement continueButton = date.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();

        WebElement messageOnTheTop = date.findElement(By.xpath("//font[@size='4']"));
        Assert.assertEquals(BrowserUtils.getText(messageOnTheTop), "After flight finder - No Seats Avaialble  ");
      }





    }

