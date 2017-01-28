package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    public CheckOutPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.ID, using = "email")
    public WebElement email;

    @FindBy(how = How.ID, using = "name")
    public WebElement name;

    @FindBy(how = How.ID, using = "address")
    public WebElement address;

    @FindBy(how = How.ID, using = "card_type")
    public WebElement cardType;

    @FindBy(how = How.ID, using = "card_number")
    public WebElement cardNumber;

    @FindBy(how = How.ID, using = "cardholder_name")
    public WebElement cardHolderName;

    @FindBy(how = How.ID, using = "verification_code")
    public WebElement verificationCode;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']")
    public WebElement placeOrderBtn;

    @FindBy(how = How.CLASS_NAME, using = "btn")
    public WebElement cancelBtn;


}
