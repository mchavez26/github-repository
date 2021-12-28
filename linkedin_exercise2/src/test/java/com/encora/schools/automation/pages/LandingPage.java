package com.encora.schools.automation.pages;

import com.encora.schools.automation.test.BaseTest;
import org.omg.CORBA.BAD_CONTEXT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver webdriver){
        super(webdriver);
    }

    public By signInBy = By.cssSelector(".nav__button-secondary");
    //private By usernameBy = By.id("username"); //also works

    //private By logoBy = By.cssSelector(".logo");
    //private By searchBoxBy = By.id("search_query_top");
    //private By cartPreviewBy = By.cssSelector(".shopping_cart");

    //my code to click sign in
    public void clickSignin(){
        clickElement(signInBy);
    }

    //public boolean isLogoDisplayed(){
    //    return isElementDisplayed(logoBy);
    //}

}
