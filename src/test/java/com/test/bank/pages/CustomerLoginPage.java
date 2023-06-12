package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerLoginPage {

    public CustomerLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    @FindBy(css = "#userSelect")
    WebElement yourName;
    @FindBy(xpath = "//button[@type='submit']") ///button[.='Customer Login']
    WebElement loginButton;
   @FindBy(xpath = "//button[@class='btn btn-primary btn-lg']")
    WebElement customerLoginButton;

    @FindBy(xpath = "//strong[contains(text(),' Welcome ')]")
    WebElement header;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement depositButton;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitDeposit;

    @FindBy(xpath = "//input[@type='number']")
    WebElement amount;

    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement depositMessage;

    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawButton;
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withdrawalAmount;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitwithDrawl;
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement successMessage;

    @FindBy(xpath = "//div[@ng-binding='noAccount']//strong[2]")
    WebElement balance;
    @FindBy(xpath = "//button[@class='btn btn-lg tab']")
    WebElement transactionBalance;
    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement depositCredit;
    @FindBy(xpath = "//tr[@id='anchor0']//td[1]")
    WebElement withDrawlDebit;

    public void loginFunctionality(String customerName,String expectedMessage) throws InterruptedException {
        BrowserUtils.selectBy(yourName, "Nazgul Jumanova ", "text");
        Thread.sleep(2000);
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(header),expectedMessage);
    }
    public void depositFunctionality(String depositAmount,String expected) throws InterruptedException {
        depositButton.click();
        Thread.sleep(500);
        amount.sendKeys(depositAmount);
       submitDeposit.submit();
        Assert.assertEquals(BrowserUtils.getText(depositMessage),expected);
    }
    public void clickCustomerLogin() {
        loginButton.click();

    }
    public void SelectYourNameValidateMessage(String expectedName) {
        loginButton.click();
        BrowserUtils.selectBy(yourName, expectedName, "text");
        loginButton.click();
    }
    public String getDepositMessage() {
        return depositMessage.getText();

    }
    public void withdrawlFunctionality() throws InterruptedException {
        withdrawButton.click();
        Thread.sleep(2000);
        withdrawalAmount.sendKeys("300");
        submitwithDrawl.click();

    }
    public String getTransactionMessege() {
        return successMessage.getText();
    }
    public void transactionFunctionality() throws InterruptedException {
        int actualBalance=Integer.parseInt(BrowserUtils.getText(balance));//200
        Thread.sleep(1000);
        transactionBalance.click();
        int expectedBalance=Integer.parseInt(BrowserUtils.getText(depositCredit))-
        Integer.parseInt(BrowserUtils.getText(withDrawlDebit));
        Assert.assertEquals(actualBalance,expectedBalance);

    }
}



