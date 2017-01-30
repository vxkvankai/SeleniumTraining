package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {


    public WelcomePage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.ID, using = "wsb-button-00000000-0000-0000-0000-000450914890")
    public WebElement seeCollectionBtn1;

    @FindBy(how = How.ID, using = "wsb-button-00000000-0000-0000-0000-000450914897")
    public WebElement seeCollectionBtn2;


    @FindBy(how = How.ID, using = "wsb-button-00000000-0000-0000-0000-000450914899")
    public WebElement seeCollectionBtn3;



}
