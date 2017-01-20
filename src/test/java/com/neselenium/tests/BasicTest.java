package com.neselenium.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.drivers.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasicTest {

    WebDriver d;
    WebDriverWait wait;
    DriverInit driver = new DriverInit(null);
    //WebDriver driver;
    // private long SLEEPTIME = 5000;

    @BeforeClass(alwaysRun = true)
    public void launchBrowser(ITestContext context) throws ClassNotFoundException {

        driver.initDriver(context);
        wait = driver.getWait();
        d = driver.getDriver();
        d.navigate().to("http://www.practiceselenium.com");

    }


    @Test(priority = 10, groups = {"test", "smoketest"})
    public void goToUrl(ITestContext context) throws InterruptedException {

        Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Welcome")));

    }


    @Test(priority = 15, groups = {"test", "smoketest"})
    public void ourPassion() throws InterruptedException {

        // d.findElement(By.xpath("//*[@data-title='Our Passion']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(d.findElement(By.xpath("//*[@data-title='Our Passion']"))))
            .sendKeys(Keys.ENTER);
        Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Our Passion")));

    }


    @Test(priority = 20, groups = {"test"})
    public void clickMenu() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(d.findElement(By.xpath("//*[@data-title='Menu']"))))
            .sendKeys(Keys.RETURN);
        Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Menu")));

    }


    @Test(priority = 25, groups = {"test", "smoketest"})
    public void LetsTalkTea() throws InterruptedException {

        // Herb, i replaced let's talk escape character in "d.findElement(By.linkText("Let\'s Talk Tea")).click()" with the following format: //*[@data-url='let-s-talk-tea.html'] ;

        wait.until(ExpectedConditions.elementToBeClickable(d.findElement(By.xpath("//*[@data-url='let-s-talk-tea.html']"))))
            .sendKeys(Keys.RETURN);
        Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Let\'s Talk Tea")));
    }


    @Test(priority = 35, groups = {"test", "smoketest"})
    public void CheckOut() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(d.findElement(By.xpath("//*[@data-title='Check Out']"))))
            .sendKeys(Keys.RETURN);
        //d.findElement(By.linkText("Check Out")).sendKeys(Keys.ENTER);
        Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Check Out")));
        Thread.sleep(60);
    }

    @Test(priority = 40, groups = {"test", "smoketest"})
    public void CustomerInfoForm() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(d.findElement(By.xpath("//input[contains(@id,'email']"))))
            .sendKeys("tester@test.com");
        //        //d.findElement(By.linkText("Check Out")).sendKeys(Keys.ENTER);
        //        Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Check Out")));
    }


    @AfterMethod(alwaysRun = true)
    public void logResults(ITestContext context, ITestResult result) {

    }

    @AfterClass(alwaysRun = true)
    public void terminateApp(ITestContext context) {

        if (d != null) {
            d.close();
            d.quit();
            driver.setDriver(null);
        }
    }

}
