/**
 * 
 */
package com.neselenium.tests;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.utils.BasePage;

public class CheckOutForm extends BasePage {

    // Input field locators for checkout page
    By email = By.id("email");
    By Name = By.id("name");
    By Address = By.id("adress");
    By CardType = By.id("card_type");
    By CardNumber = By.id("card_number");
    By CardHolderName = By.id("cardholder_name");
    By VerificationCode = By.id("verification_code");

    By checkOutLink = By.xpath("//a[@data-title=\"Check Out\"]");

    public void CheckOut() {

        clickElement(checkOutLink);
        //clickElement(driver.findElement(By.xpath("//a[@data-title='Check Out']")));
        Assert.assertTrue(verifyTitle("Check Out"));

        sendTextToInputFld(email, "vamsi@gmail.com");



        //        int OptionsSize = driver.findElements(By.xpath("//select[contains(@id,'card_type')]")).size();
        //        System.out.println("Size of the List:" + OptionsSize);
        //        List<WebElement> cardType = driver.findElements(By.xpath("//select[contains(@id,'card_type')]"));
        //
        //
        //        for (WebElement card : cardType) {
        //            System.out.print("Text for card type" + card.getText() + "\t");
        //
        //        }



    }

}
