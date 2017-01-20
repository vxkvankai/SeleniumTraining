package com.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.drivers.DriverInit;

public class BasePage extends DriverInit {

    public void clickElement(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(Keys.RETURN);

    }

}
