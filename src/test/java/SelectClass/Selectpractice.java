package SelectClass;

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

public class Selectpractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(" file:///Users/nazgul/Desktop/Techtorial.html ");
        WebElement optionBox = driver.findElement(By.xpath("//select[@name='country']"));
        Select choice = new Select(optionBox);
        String actualDefaultChoice = choice.getFirstSelectedOption().getText().trim();
        String expectedDefaultChoice = "UNITED STATES";
        Assert.assertEquals(actualDefaultChoice,expectedDefaultChoice);
        //Task2
        List<WebElement> allCountry=choice.getOptions();
        int counter=0;
        for(WebElement country : allCountry){
            System.out.println(country.getText().trim());
            counter++;
        }
        System.out.println(counter);

        WebElement ownCountry=driver.findElement(By.xpath("//select[@name='country']"));
        Select choose= new Select(ownCountry);
        choose.selectByVisibleText("KYRGYZSTAN".trim());
        Thread.sleep(1000);
        choose.selectByValue("61");
        Thread.sleep(1000);
        choose.selectByIndex(88);







}}
