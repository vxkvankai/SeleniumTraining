/**
 * 
 */
package com.neselenium.tests;

import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckOutForm extends BasicTest {

    // trying to implement list enlements for credit card options

    public void CheckOut() {

        clickElement(checkOutLink);
        //clickElement(driver.findElement(By.xpath("//a[@data-title='Check Out']")));
        Assert.assertTrue(verifyTitle("Check Out"));

        int OptionsSize = driver.findElements(By.xpath("//select[contains(@id,'card_type')]")).size();
        System.out.println("Size of the List:" + OptionsSize);
        List<WebElement> cardType = driver.findElements(By.xpath("//select[contains(@id,'card_type')]"));


        for (WebElement card : cardType) {
            System.out.print("Text for card type" + card.getText() + "\t");

        }



    }

}
