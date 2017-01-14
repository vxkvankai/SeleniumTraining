package com.neselenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BasicTest  {

    WebDriver driver = null;
    private long SLEEPTIME = 5000;

    @BeforeClass(alwaysRun = true)
    public void launchBrowser(ITestContext context) throws ClassNotFoundException {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        //System.setProperty("browser", value)
        driver = new FirefoxDriver();
        //driver = DriverInitializer.getDriver();

    }

    @Test(priority = 10, groups = {"test", "smoketest"})
    public void goToUrl() throws InterruptedException {

        driver.navigate().to("http://www.practiceselenium.com");

        Thread.sleep(SLEEPTIME);

        Assert.assertEquals("Welcome", driver.getTitle());

    }

    @Test(priority = 15, groups = {"test", "smoketest"})
    public void ourPassion() throws InterruptedException {

        driver.findElement(By.xpath("//*[@data-title='Our Passion']")).click();

        Thread.sleep(SLEEPTIME);

        Assert.assertEquals("Our Passion", driver.getTitle());


    }

    @Test(priority = 20, groups = {"test"})
    public void clickMenu() throws InterruptedException {


        driver.findElement(By.xpath("//*[@data-title='Menu']")).click();

        Thread.sleep(SLEEPTIME);

        Assert.assertEquals("Menu", driver.getTitle());


    }

    @Test(priority = 25, groups = {"test", "smoketest"})
    public void LetsTalkTea() throws InterruptedException {

       driver.findElement(By.linkText("Let\'s Talk Tea")).click();
       Thread.sleep(SLEEPTIME);
       Assert.assertEquals("Let\'s Talk Tea", driver.getTitle());

  }


    @Test(priority = 35, groups = {"test", "smoketest"})
    public void CheckOut() throws InterruptedException {

       driver.findElement(By.linkText("Check Out")).click();
       Thread.sleep(SLEEPTIME);
       Assert.assertEquals("Check Out", driver.getTitle());

  }
    
    
    @AfterMethod(alwaysRun = true)
    public void logResults(ITestContext context, ITestResult result) {

    }

    @AfterClass(alwaysRun = true)
    public void terminateApp(ITestContext context) {

        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

}
