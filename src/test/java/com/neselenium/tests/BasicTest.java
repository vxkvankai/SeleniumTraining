package com.neselenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.BasePage;
import com.utils.TestngContext;


public class BasicTest extends BasePage {

    WebDriver d;
    WebDriverWait wait;


    @BeforeClass(alwaysRun = true)
    public void launchBrowser(ITestContext context) throws ClassNotFoundException {

        //Putting the context into a static class to access from anywhere
        TestngContext.setContext(context);

        d = setDriver(); //get the driver;
        wait = getWait();
        d.get("http://www.practiceselenium.com");

    }

    @Test(priority = 10, groups = {"test", "smoketest"})
    public void goToUrl(ITestContext context) throws InterruptedException {

        Assert.assertEquals("Welcome", d.getTitle());

    }

    @Test(priority = 15, groups = {"test", "smoketest"})
    public void ourPassion() throws InterruptedException {

        clickElement(d.findElement(By.xpath("//a[@data-title='Our Passion']")));
        Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Our Passion")));

    }

    @Test(priority = 20, groups = {"test"})
    public void clickMenu() throws InterruptedException {

        clickElement(d.findElement(By.xpath("//*[@data-title='Menu']")));

        Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Menu")));

    }

    @Test(priority = 25, groups = {"test", "smoketest"})
    public void LetsTalkTea() throws InterruptedException {

        clickElement(d.findElement(By.xpath("//a[@data-title=\"Let's Talk Tea\"]")));

        Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Let's Talk Tea")));

    }


    @Test(priority = 35, groups = {"test", "smoketest"})
    public void CheckOut() throws InterruptedException {

        clickElement(d.findElement(By.xpath("//a[@data-title='Check Out']")));

        Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Check Out")));

    }


    @AfterClass(alwaysRun = true)
    public void terminateApp(ITestContext context) {

        if (d != null) {
            d.close();
            d.quit();
            setDriver(null);
        }
    }

}
