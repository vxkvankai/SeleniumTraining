package com.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.TestngContext;

public class DriverInit {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver setDriver() {

        switch (TestngContext.getContext().getCurrentXmlTest().getParameter("browse")) {

            case "Firefox":
                System.setProperty("webdriver.gecko.driver",
                    TestngContext.getContext().getCurrentXmlTest().getParameter("driverpath"));
                driver = new FirefoxDriver();
                break;

            case "Chrome":
                System.setProperty("webdriver.chrome.driver",
                    TestngContext.getContext().getCurrentXmlTest().getParameter("driverpath"));
                driver = new ChromeDriver();
                break;

            case "IE":
                System.setProperty("webdriver.ie.driver",
                    TestngContext.getContext().getCurrentXmlTest().getParameter("driverpath"));
                driver = new InternetExplorerDriver();
                DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
                ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                break;

            default:
                System.setProperty("webdriver.gecko.driver",
                    TestngContext.getContext().getCurrentXmlTest().getParameter("driverpath"));
                driver = new FirefoxDriver();
                break;

        }

        setWait();
        driver.manage().window().maximize();

        return getDriver();
    }


    public static void setWait() {
        wait = new WebDriverWait(driver, 60);
    }

    public static WebDriverWait getWait() {
        return wait;
    }

}
