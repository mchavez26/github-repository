package com.encora.schools.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage{

    public SearchResultsPage(WebDriver webdriver) {
        super(webdriver);
    }

    //private By viewFullProfileButton = By.cssSelector(".app-aware-link.artdeco-button.artdeco-button--default.artdeco-button--2.artdeco-button--secondary"); //also didn't work, update: with the correct css it worked
    private By viewFullProfileButton = By.cssSelector(".app-aware-link.artdeco-button.artdeco-button--default.artdeco-button--2.artdeco-button--primary"); //also didn't work, update: with the correct css it worked

    public void clickViewFullProfileButton(){
        clickElement(viewFullProfileButton);
    }

}
