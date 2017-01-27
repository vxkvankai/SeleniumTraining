package com.neselenium.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.LinkPages;
import com.utils.BasePage;
import com.utils.TestngContext;


public class BasicTest extends BasePage {

    //    By passionLink = By.xpath("//a[@data-title=\"Our Passion\"]");
    //    By menuLink = By.xpath("//a[@data-title=\"Menu\"]");
    //    By talkLink = By.xpath("//a[@data-title=\"Let's Talk Tea\"]");
    //    By checkOutLink = By.xpath("//a[@data-title=\"Check Out\"]");
    //
    //
    //    // Input field locators for customer info page
    //    By email = By.id("email");
    //    By Name = By.id("name");
    //    By Address = By.id("adress");
    //    By CardType = By.id("card_type");
    //    By CardNumber = By.id("card_number");
    //    By CardHolderName = By.id("cardholder_name");
    //    By VerificationCode = By.id("verification_code");
    // ERROR:  By PlaceOrderBtn = By.className('btn btn-primary'); //button[@class='btn btn-primary']

    // driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary')]"));
    //button[@class='btn btn-primary firepath-matching-node']


    private LinkPages linksPages;

    @BeforeClass(alwaysRun = true)
    public void launchBrowser(ITestContext context) {

        //Putting the context into a static class to access from anywhere
        TestngContext.setContext(context);

        setDriver(); //get the driver;

        linksPages = new LinkPages(getDriver());


    }

    @Test(priority = 10, groups = {"test", "smoketest"})
    public void navigateToUrl() {

        goToUrl("http://www.practiceselenium.com");

        Assert.assertTrue(verifyTitle("Welcome"));

    }

    @Test(priority = 15, groups = {"test", "smoketest"})
    public void ourPassion() throws InterruptedException {

        clickElement(linksPages.passionLink);
        //clickElement(passionLink);
        //clickElement(driver.findElement(By.xpath("//a[@data-title='Our Passion']")));
        //Assert.assertTrue(wait.until(ExpectedConditions.titleContains("")));
        Assert.assertTrue(verifyTitle("Our Passion"));

    }

    @Test(priority = 20, groups = {"test"})
    public void clickMenu() {

        clickElement(linksPages.menuLink);
        //clickElement(menuLink);
        //clickElement(driver.findElement(By.xpath("//*[@data-title='Menu']")));

        //Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Menu")));
        Assert.assertTrue(verifyTitle("Menu"));

    }

    @Test(priority = 25, groups = {"test", "smoketest"})
    public void LetsTalkTea() {

        clickElement(linksPages.talkLink);
        //clickElement(talkLink);
        //clickElement(driver.findElement(By.xpath("//a[@data-title=\"Let's Talk Tea\"]")));

        //Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Let's Talk Tea")));
        Assert.assertTrue(verifyTitle("Let's Talk Tea"));

    }

    @AfterClass(alwaysRun = true)
    public void terminateApp() {

        tearDown();
    }

}
