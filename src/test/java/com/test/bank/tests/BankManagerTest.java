package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest extends BankTestBase{

    @Test
    public void validateAddCustomerFunctionality() throws InterruptedException {

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Nazgul", "Jumanova", "11229", "Customer added successfully with customer id");

    }

    @Test
    public void validateOpenAccountFunctionality() throws InterruptedException {

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Nazgul", "Jumanova", "11229", "Customer added successfully with customer id");

        bankManagerPage.OpenAccountFunctionality(driver, "Nazgul Jumanova", "Dollar",
                "Account created successfully with account Number");
    }
    @Test
    public void validateCustomerFunctionality() throws InterruptedException {

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Nazgul", "Jumanova", "11229", "Customer added successfully with customer id");

        bankManagerPage.OpenAccountFunctionality(driver, "Nazgul Jumanova", "Dollar",
                "Account created successfully with account Number");

        bankManagerPage.customersFunctionality("Nazgul", "Jumanova", "11229");

    }
}

