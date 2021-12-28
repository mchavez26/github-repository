package com.encora.schools.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver webdriver) {
        super(webdriver);
    }
    private By skipButtonBy = By.cssSelector(".secondary-action");
    private By meBy = By.id("ember30");
    //private By profileBy = By.id("ember73"); // does not work because this ember is changing
    private By profileBy = By.cssSelector(".feed-identity-module__member-photo"); //also didn't work, update: with the correct css it worked
    //private By searchBarBy = By.cssSelector(".search-global-typeahead.global-nav__search-typeahead");
    private By searchBarBy = By.cssSelector(".search-global-typeahead__input.always-show-placeholder");
    private By searchBarResultBy = By.cssSelector(".typeahead-suggestion .search-global-typeahead__hit-text");
    private By signOutButton = By.cssSelector(".global-nav__secondary-link.mv1");
    private By meButton = By.cssSelector(".global-nav__primary-link.artdeco-dropdown__trigger.artdeco-dropdown__trigger--placement-bottom.ember-view");
    private By signOutButton2 = By.cssSelector(".full-width.mt4.artdeco-button.artdeco-button--muted.artdeco-button--2.artdeco-button--secondary.ember-view");
    public By welcomeButton = By.cssSelector(".ember-view.block .t-16.t-black.t-bold");

    //my code to click skip
    public void clickSkip(){
        clickElement(skipButtonBy);
    }

    //my code to click me
    public void clickMe(){
        clickElement(meBy);
    }

    //my code to click profile
    public void clickProfile(){
        clickElement(profileBy);
    }

    //my code to click searchbar
    public void clickSearchBar(){
        clickElement(searchBarBy);
    }

    public void sendSearchUser(){
        sendText(searchBarBy , "Edwin Manuel Chavez");
    }

    public WebElement getSearchResultWithText(String text){
        List<WebElement> searchResults = findElements(searchBarResultBy);
        for (WebElement candidate: searchResults ){ // move through all the elements from the list
            String candidateText = candidate.getText();
            if (candidateText.toLowerCase().equals(text.toLowerCase())){ ////////Figure out why these are not equal
                return candidate;
            }
        }
        return null;
    }

    public void clickMeButton(){
        clickElement(meButton);
    }

    public void clickSignOutButton(){
        clickElement(signOutButton);
    }

    public void clickSignOutButton2(){
        clickElement(signOutButton2);
    }

    public boolean isWelcomeDisplayed(){
        return isElementDisplayed(welcomeButton);
    }

}

