package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NavLinkPage {

    public NavLinkPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.XPATH, using = "//a[@data-title=\"Our Passion\"]")
    public WebElement passionLink;


    @FindBy(how = How.XPATH, using = "//a[@data-title=\"Menu\"]")
    public WebElement menuLink;

    @FindBy(how = How.XPATH, using = "//a[@data-title=\"Let's Talk Tea\"]")
    public WebElement talkLink;

    @FindBy(how = How.XPATH, using = "//a[@data-title=\"Check Out\"]")
    public WebElement checkOutLink;


}

