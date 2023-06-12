package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class LocatersIntro {
    //LOCATERS --> is a way to located(find) elemnt and manipulate on it
    public static void main(String[] args) throws InterruptedException {


//ID location

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/nazgul/Desktop/Techtorial.html ");
        driver.manage().window().maximize();
        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualHeader = header.getText().trim();// It gets the text from element
        String expectedHeader = "Techtorial Academy";
        System.out.println(header.getText());
        System.out.println(actualHeader.equals(expectedHeader) ? "CORRECT" : "WRONG");
        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        //NAME LOCATOR

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Nazgul");
        WebElement LastName = driver.findElement(By.name("lastName"));
        LastName.sendKeys("Bekbolotova");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("3473721043");
        WebElement userName = driver.findElement(By.name("userName"));
        userName.sendKeys("fashionazi@mail.ru");
        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("5451 E North ");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Chicago");
        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement postalCode = driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("60656");

        //CLASS LOCATOR

        WebElement allTools = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());
        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && !javaBox.isSelected()) {
            javaBox.click();
        }
        System.out.println(javaBox.isSelected() ? "SELECTED" : "NOT SELECTED");

        WebElement TestNG = driver.findElement(By.id("cond3"));
        if (TestNG.isDisplayed() && !TestNG.isSelected()) {
            TestNG.click();
        }
        System.out.println(TestNG.isSelected() ? "SELECTED" : "NOT SELECTED");

    WebElement cucumber = driver.findElement(By.id("cond3"));
        if (cucumber.isDisplayed() && !TestNG.isSelected()) {
        cucumber.click();
    }
        System.out.println(cucumber.isSelected() ? "SELECTED" : "NOT SELECTED");

        //TAG NAME LOCATED--> COLORFUL

        WebElement herder2= driver.findElement(By.tagName("h1"));
        System.out.println(herder2.getText());
        WebElement javaVersion = driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText());
        Thread.sleep(2000);
        driver.quit();

}
}