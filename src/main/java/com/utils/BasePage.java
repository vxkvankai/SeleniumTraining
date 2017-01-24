package com.utils;

import com.drivers.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends DriverInit {

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

    public void sendTextToInputFld(WebElement element_enter) {
        element_enter.sendKeys("teter@test.com");
        element_enter.sendKeys("tester");
        element_enter.sendKeys("26000 Dodge st, Omaha NE 68123");

    }
}
