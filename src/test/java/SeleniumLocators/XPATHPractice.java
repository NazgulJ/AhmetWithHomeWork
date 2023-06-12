package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register ");
        WebElement firstname = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstname.sendKeys("Nazgul");
        WebElement lastname = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastname.sendKeys("Bekbolotova");
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("fashnaz6zi@mail.ru");
        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        telephone.sendKeys("321-345-7767");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("12345");
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        confirmPassword.sendKeys("12345");
        WebElement agree = driver.findElement(By.xpath("//input[@name='agree']"));
        Thread.sleep(2000);
        agree.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        Thread.sleep(2000);
        continueButton.click();
        WebElement header=driver.findElement(By.xpath("//h1[.='Your Account Has Been Created!']"));
        String actualHeader=driver.getTitle();
        String expectedHEADER="Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHEADER) ? "Passed" : "Failed");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://tutorialsninja.com/demo/index.php?route=account/success";
        System.out.println(actualUrl.equals(expectedUrl) ? "account Passed" : "account Failed");
        WebElement continueButton1= driver.findElement(By.xpath("//input[a.'Continue']"));
        continueButton1.click();
    }}

