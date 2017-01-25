/**
 * 
 */
package com.neselenium.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.BasePage;
import com.utils.TestngContext;
import org.openqa.selenium.By;

public class CheckOutForm extends BasePage {

    // Input field locators for checkout page
    By email = By.id("email");
    By Name = By.id("name");
    By Address = By.id("address");
    By CardType = By.id("card_type");
    By CardNumber = By.id("card_number");
    By CardHolderName = By.id("cardholder_name");
    By VerificationCode = By.id("verification_code");
    By PlaceOrderBtn = By.xpath("//button[@class='btn btn-primary']");
    By checkOutLink = By.xpath("//a[@data-title=\"Check Out\"]");

    @BeforeClass(alwaysRun = true)
    public void launchBrowser(ITestContext context) {

        //Putting the context into a static class to access from anywhere
        TestngContext.setContext(context);

        setDriver(); //get the driver;

        driver.get("http://www.practiceselenium.com");

        Assert.assertTrue(verifyTitle("Welcome"));

    }

    @Test
    public void CheckOut() {

        clickElement(checkOutLink);
        //clickElement(driver.findElement(By.xpath("//a[@data-title='Check Out']")));
        Assert.assertTrue(verifyTitle("Check Out"));

        sendTextToInputFld(email, "vamsi@gmail.com");
        sendTextToInputFld(Name, "vamsi");
        sendTextToInputFld(Address, "21 dodge st, omaha");
        sendTextToInputFld(CardNumber, "12345667889");
        sendTextToInputFld(CardHolderName, "vamsi k");
        sendTextToInputFld(VerificationCode, "231");



        selectDropDown(CardType, "Diners Club");
        // sleep(10000);

        click(PlaceOrderBtn);
        Assert.assertTrue(verifyTitle("Menu"));

    }

    @AfterClass(alwaysRun = true)
    public void terminateApp() {

        tearDown();
    }

}
