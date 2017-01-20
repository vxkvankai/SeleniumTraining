package com.drivers;

import org.testng.ITestContext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverInit {
    WebDriverWait wait;
    private WebDriver driver;

    public DriverInit(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void initDriver(ITestContext context) {

        switch (context.getCurrentXmlTest().getParameter("browse")) {

            case "Firefox":
                System.setProperty("webdriver.gecko.driver", context.getCurrentXmlTest().getParameter("driverpath"));
                driver = new FirefoxDriver();
                break;

            case "Chrome":
                System.setProperty("webdriver.chrome.driver", context.getCurrentXmlTest().getParameter("driverpath"));
                driver = new ChromeDriver();
                break;

            case "IE":
                System.setProperty("webdriver.ie.driver", context.getCurrentXmlTest().getParameter("driverpath"));
                WebDriver driver = new InternetExplorerDriver();
                DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
                ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

            default:
                System.setProperty("webdriver.gecko.driver", context.getCurrentXmlTest().getParameter("driverpath"));
                driver = new FirefoxDriver();
                break;


        }
        setWait();
        driver.manage().window().maximize();
    }

    public void setWait() {
        wait = new WebDriverWait(driver, 60);

    }

    public WebDriverWait getWait() {
        return wait;
    }
}
