package com.test.bank.tests;

import com.test.bank.pages.CustomerLoginPage;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankCustomerTest extends BankTestBase {


    @Test
    public void validateCustomerLoginTransactions() throws InterruptedException {

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Nazgul", "Jumanova", "11229", "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver, "Nazgul Jumanova", "Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customersFunctionality("Nazgul", "Jumanova", "11229");
        bankManagerPage.clickHomeButton();
        CustomerLoginPage bankCustomerPage = new CustomerLoginPage(driver);
        bankCustomerPage.clickCustomerLogin();
        bankCustomerPage.SelectYourNameValidateMessage("Nazgul Jumanova ");
        //bankCustomerPage.depositFunctionality();
        Assert.assertEquals(bankCustomerPage.getDepositMessage(), "Deposit Successful");
        bankCustomerPage.withdrawlFunctionality();
        Assert.assertEquals(bankCustomerPage.getTransactionMessege(), "Transaction successful");
        bankCustomerPage.transactionFunctionality();
    }
}