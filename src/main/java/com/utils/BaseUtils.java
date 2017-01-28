package com.utils;

import com.drivers.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BaseUtils extends DriverInit {

    public void goToUrl(String url) {
        driver.get("http://www.practiceselenium.com");
    }

    public void clickElement(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(Keys.RETURN);

    }

    //this is example of overload
    public void clickElement(By element) {

        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(Keys.RETURN);

    }

    public boolean verifyTitle(String title) {

        return wait.until(ExpectedConditions.titleContains(title));

    }

    // adding new method to send text
    public void sendTextToInputFld(By element, String what) {

        wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(what);
    }

    public void sendTextToInputFld(WebElement element, String what) {

        wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(what);
    }

    public void selectDropDown(By type, String what) {

        wait.until(ExpectedConditions.elementToBeClickable(type));
        WebElement element = driver.findElement(type);

        Select oSelect = new Select(element);

        oSelect.selectByVisibleText(what);

    }

    public void selectDropDown(WebElement type, String what) {

        wait.until(ExpectedConditions.elementToBeClickable(type));
        //WebElement element = driver.findElement(type);

        Select oSelect = new Select(type);

        oSelect.selectByVisibleText(what);

    }

    //    public void click(By element) {
    //
    //        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    //    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }
}
