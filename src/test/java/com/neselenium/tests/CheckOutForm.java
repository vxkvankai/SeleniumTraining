/**
 * 
 */
package com.neselenium.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.CheckOutPage;
import com.pages.NavLinkPage;
import com.pages.OurPassionPage;
import com.pages.WelcomePage;
import com.utils.BaseUtils;
import com.utils.TestngContext;

public class CheckOutForm extends BaseUtils {

    // Input field locators for checkout page
    private NavLinkPage linksPage;
    private CheckOutPage checkOutPage;
    private WelcomePage welcomePage;
    private OurPassionPage ourPassionPage;

    @BeforeClass(alwaysRun = true)
    public void launchBrowser(ITestContext context) {

        //Putting the context into a static class to access from anywhere
        TestngContext.setContext(context);

        setDriver(); //get the driver;

        linksPage = new NavLinkPage(getDriver());
        welcomePage = new WelcomePage(getDriver());
        ourPassionPage = new OurPassionPage(getDriver());
        checkOutPage = new CheckOutPage(getDriver());

        goToUrl("http://www.practiceselenium.com");
        Assert.assertTrue(verifyTitle("Welcome"));

    }

    @Test(priority = 10)
    public void CheckOut() {

        clickElement(linksPage.checkOutLink);
        //clickElement(driver.findElement(By.xpath("//a[@data-title='Check Out']")));
        Assert.assertTrue(verifyTitle("Check Out"));

        sendTextToInputFld(checkOutPage.email, "vamsi@gmail.com");
        sendTextToInputFld(checkOutPage.name, "vamsi");
        sendTextToInputFld(checkOutPage.address, "21 dodge st, omaha");
        sendTextToInputFld(checkOutPage.cardNumber, "12345667889");
        sendTextToInputFld(checkOutPage.cardHolderName, "vamsi k");
        sendTextToInputFld(checkOutPage.verificationCode, "231");



        selectDropDown(checkOutPage.cardType, "Diners Club");
        // sleep(10000);

        clickElement(checkOutPage.placeOrderBtn);
        Assert.assertTrue(verifyTitle("Menu"));

    }

    @Test(priority = 20)
    public void CheckOutCancel() {

        clickElement(linksPage.checkOutLink);
        //clickElement(driver.findElement(By.xpath("//a[@data-title='Check Out']")));
        Assert.assertTrue(verifyTitle("Check Out"));

        sendTextToInputFld(checkOutPage.email, "vamsi@gmail.com");
        sendTextToInputFld(checkOutPage.name, "vamsi");
        sendTextToInputFld(checkOutPage.address, "21 dodge st, omaha");
        sendTextToInputFld(checkOutPage.cardNumber, "12345667889");
        sendTextToInputFld(checkOutPage.cardHolderName, "vamsi k");
        sendTextToInputFld(checkOutPage.verificationCode, "231");



        selectDropDown(checkOutPage.cardType, "Diners Club");
        // sleep(10000);

        clickElement(checkOutPage.cancelBtn);
        Assert.assertTrue(verifyTitle("Menu"));

    }

    @AfterClass(alwaysRun = true)
    public void terminateApp() {

        tearDown();
    }

}
