package com.neselenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.drivers.Driverinit;


public class BasicTest  {

    Driverinit driver = new Driverinit(null);
	private long SLEEPTIME = 5000;

    @BeforeClass(alwaysRun = true)
    public void launchBrowser(ITestContext context) throws ClassNotFoundException {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        driver.setDriver(new FirefoxDriver());
    	
//    	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
//    	driver.setDriver(new ChromeDriver());
        driver.getDriver().manage().window().maximize();

        
        // NOTE HERB: tried to set IE but it did not work. It lanuches blank Chrome browser 
//        System.setProperty("webdriver.internetExplorer.driver", "src/test/resources/IEDriverServer.exe");
//        driver.setDriver(new internetExplorer.driver());
//        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer(); 
//        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
       // driver = new InternetExplorerDriver(ieCapabilities);
        //System.setProperty("browser", value)          WebDriver driver = new InternetExplorerDriver(ieCapabilities);
      
        //driver = DriverInitializer.getDriver();

    }

    @Test(priority = 10, groups = {"test", "smoketest"})
    public void goToUrl() throws InterruptedException {

        driver.getDriver().navigate().to("http://www.practiceselenium.com");

        Thread.sleep(SLEEPTIME);

        Assert.assertEquals("Welcome", driver.getDriver().getTitle());

    }

    @Test(priority = 15, groups = {"test", "smoketest"})
    public void ourPassion() throws InterruptedException {

        driver.getDriver().findElement(By.xpath("//*[@data-title='Our Passion']")).click();

        Thread.sleep(SLEEPTIME);

        Assert.assertEquals("Our Passion", driver.getDriver().getTitle());


    }

    @Test(priority = 20, groups = {"test"})
    public void clickMenu() throws InterruptedException {


        driver.getDriver().findElement(By.xpath("//*[@data-title='Menu']")).click();

        Thread.sleep(SLEEPTIME);

        Assert.assertEquals("Menu", driver.getDriver().getTitle());


    }

    @Test(priority = 25, groups = {"test", "smoketest"})
    public void LetsTalkTea() throws InterruptedException {

       driver.getDriver().findElement(By.linkText("Let\'s Talk Tea")).click();
       Thread.sleep(SLEEPTIME);
       Assert.assertEquals("Let\'s Talk Tea", driver.getDriver().getTitle());

  }


    @Test(priority = 35, groups = {"test", "smoketest"})
    public void CheckOut() throws InterruptedException {

       driver.getDriver().findElement(By.linkText("Check Out")).click();
       Thread.sleep(SLEEPTIME);
       Assert.assertEquals("Check Out", driver.getDriver().getTitle());

  }
    
    
    @AfterMethod(alwaysRun = true)
    public void logResults(ITestContext context, ITestResult result) {

    }

    @AfterClass(alwaysRun = true)
    public void terminateApp(ITestContext context) {

        if (driver.getDriver() != null) {
            driver.getDriver().close();
            driver.getDriver().quit();
            driver.setDriver(null);
        }
    }

}