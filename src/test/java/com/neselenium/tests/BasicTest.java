package com.neselenium.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.BasePage;
import com.utils.TestngContext;


public class BasicTest extends BasePage {

    By passionLink = By.xpath("//a[@data-title=\"Our Passion\"]");
    By menuLink = By.xpath("//a[@data-title=\"Menu\"]");
    By talkLink = By.xpath("//a[@data-title=\"Let's Talk Tea\"]");
    By checkOutLink = By.xpath("//a[@data-title=\"Check Out\"]");

    By email = By.id("email");

    @BeforeClass(alwaysRun = true)
    public void launchBrowser(ITestContext context) {

        //Putting the context into a static class to access from anywhere
        TestngContext.setContext(context);

        setDriver(); //get the driver;

    }

    @Test(priority = 10, groups = {"test", "smoketest"})
    public void goToUrl(ITestContext context) {

        driver.get("http://www.practiceselenium.com");

        Assert.assertTrue(verifyTitle("Welcome"));

    }

    @Test(priority = 15, groups = {"test", "smoketest"})
    public void ourPassion() throws InterruptedException {

        clickElement(passionLink);
        //clickElement(driver.findElement(By.xpath("//a[@data-title='Our Passion']")));
        //Assert.assertTrue(wait.until(ExpectedConditions.titleContains("")));
        Assert.assertTrue(verifyTitle("Our Passion"));

    }

    @Test(priority = 20, groups = {"test"})
    public void clickMenu() {

        clickElement(menuLink);
        //clickElement(driver.findElement(By.xpath("//*[@data-title='Menu']")));

        //Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Menu")));
        Assert.assertTrue(verifyTitle("Menu"));

    }

    @Test(priority = 25, groups = {"test", "smoketest"})
    public void LetsTalkTea() {

        clickElement(talkLink);
        //clickElement(driver.findElement(By.xpath("//a[@data-title=\"Let's Talk Tea\"]")));

        //Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Let's Talk Tea")));
        Assert.assertTrue(verifyTitle("Let's Talk Tea"));

    }

    @Test(priority = 35, groups = {"test", "smoketest"})
    public void CheckOut() {

        clickElement(checkOutLink);
        //clickElement(driver.findElement(By.xpath("//a[@data-title='Check Out']")));

        //Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Check Out")));
        Assert.assertTrue(verifyTitle("Check Out"));

    }

    @AfterClass(alwaysRun = true)
    public void terminateApp(ITestContext context) {

        if (driver != null) {
            driver.close();
            driver.quit();
        }
        driver = null;
    }

}
