package com.neselenium.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.CheckOutPage;
import com.pages.NavLinkPage;
import com.pages.WelcomePage;
import com.utils.BaseUtils;
import com.utils.TestngContext;

public class WelcomeTest extends BaseUtils {

    private NavLinkPage linksPage;
    private CheckOutPage checkOutPage;
    private WelcomePage welcomePage;


    @BeforeClass(alwaysRun = true)
    public void launchBrowser(ITestContext context) {

        //Putting the context into a static class to access from anywhere
        TestngContext.setContext(context);
        checkOutPage = new CheckOutPage(getDriver());
        setDriver(); //get the driver;

        linksPage = new NavLinkPage(getDriver());
        welcomePage = new WelcomePage(getDriver());
        checkOutPage = new CheckOutPage(getDriver());

        goToUrl("http://www.practiceselenium.com");
        Assert.assertTrue(verifyTitle("Welcome"));

    }

    @Test(priority = 10)
    public void SeeCollection() {

        clickElement(welcomePage.seeCollectionBtn1);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //clickElement(driver.findElement(By.xpath("//a[@data-title='Check Out']")));
        Assert.assertTrue(verifyTitle("Menu"));
        System.out.println("verified execution of seeCollection method");

    }

    @AfterClass(alwaysRun = true)
    public void terminateApp() {

        tearDown();
    }
}
