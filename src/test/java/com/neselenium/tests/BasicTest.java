package com.neselenium.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.NavLinkPage;
import com.utils.BaseUtils;
import com.utils.TestngContext;


public class BasicTest extends BaseUtils {


    private NavLinkPage linksPages;

    @BeforeClass(alwaysRun = true)
    public void launchBrowser(ITestContext context) {

        TestngContext.setContext(context);

        setDriver(); //get the driver;

        linksPages = new NavLinkPage(getDriver());


    }

    @Test(priority = 10, groups = {"test", "smoketest"})
    public void navigateToUrl() {

        goToUrl("http://www.practiceselenium.com");

        Assert.assertTrue(verifyTitle("Welcome"));

    }

    @Test(priority = 15, groups = {"test", "smoketest"})
    public void ourPassion() throws InterruptedException {

        clickElement(linksPages.passionLink);

        Assert.assertTrue(verifyTitle("Our Passion"));

    }

    @Test(priority = 20, groups = {"test"})
    public void clickMenu() {

        clickElement(linksPages.menuLink);

        Assert.assertTrue(verifyTitle("Menu"));

    }

    @Test(priority = 25, groups = {"test", "smoketest"})
    public void LetsTalkTea() {

        clickElement(linksPages.talkLink);

        Assert.assertTrue(verifyTitle("Let's Talk Tea"));

    }

    @AfterClass(alwaysRun = true)
    public void terminateApp() {

        tearDown();
    }

}
