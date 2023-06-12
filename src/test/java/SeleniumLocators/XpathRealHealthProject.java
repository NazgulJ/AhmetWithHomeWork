package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathRealHealthProject {
    public static void main(String[] args) {

        /*
        //THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
         */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(new ChromeOptions());
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        //XPATH
        // WebElement makeappoitment= driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
       // makeappoitment.click();
        //CSS WITH ID
        WebElement makeAppoitment=driver.findElement(By.cssSelector("#btn-make-appointment"));
        makeAppoitment.click();
        WebElement username=driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");
        WebElement password=driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement login=driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();
        WebElement facility=driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");
        WebElement applyButton=driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        applyButton.click();
        WebElement medicaid=driver.findElement(By.xpath("//input[@name='programs']"));
        medicaid.click();
        WebElement data=driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        data.sendKeys("05/04/23");
        WebElement comment=driver.findElement(By.xpath("//textArea[@name='comment']"));
        comment.sendKeys("I would like to make in Appoitment");
       // WebElement bookappoitment=driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
       // bookappoitment.click();
        //CSS CLASS
        WebElement button=data.findElement(By.cssSelector(".btn-default"));
        button.click();
        WebElement header=driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
        String  actualAppoitment =header.getText().trim();
        String expectedAppoitment="Appointment Confirmation";
        System.out.println(actualAppoitment.equals(expectedAppoitment) ? "Passed actual" : "Failed actual");
        String headerAppoitmentUrl=driver.getCurrentUrl();
        String expectedUrl="https://katalon-demo-cura.herokuapp.com/appointment.php#summary";
        System.out.println(headerAppoitmentUrl.equals(expectedUrl) ? "Passed Url" : "Failed Url");
        WebElement goback=driver.findElement(By.linkText("Go to Homepage"));
        goback.click();
       driver.close();
    }

}
