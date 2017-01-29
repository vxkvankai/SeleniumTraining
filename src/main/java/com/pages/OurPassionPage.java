package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OurPassionPage {

    public OurPassionPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.ID, using = "email")
    public WebElement email;

}
