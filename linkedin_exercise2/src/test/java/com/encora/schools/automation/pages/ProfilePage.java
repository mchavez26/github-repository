package com.encora.schools.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver webdriver) {
        super(webdriver);
    }
    //private By editProfileBy = By.id("ember173"); // does not work because this ember is changing
    //private By editProfileBy = By.cssSelector("button li-icon[type='pencil-icon']");
    private By editProfileBy = By.cssSelector(".artdeco-button.artdeco-button--circle.artdeco-button--muted.artdeco-button--2.artdeco-button--tertiary.ember-view.mh1");
    private By lastNameBy = By.id("single-line-text-form-component-profileEditFormElement-TOP-CARD-profile-ACoAADj4yKMBCx1CkUTpIK6zQV9dfMZP48S78x0-lastName");
    private By firstNameBy = By.id("single-line-text-form-component-profileEditFormElement-TOP-CARD-profile-ACoAADj4yKMBCx1CkUTpIK6zQV9dfMZP48S78x0-firstName");
    private By saveButton = By.cssSelector("button.artdeco-button.artdeco-button--2.artdeco-button--primary.ember-view");
    private By saveToastMessage = By.cssSelector(".artdeco-toast-item.artdeco-toast-item--visible.ember-view .artdeco-toast-item__message");
    //private By lastNameInProfileBy = By.cssSelector(".text-heading-xlarge.inline.t-24.v-align-middle.break-words");
    //private By lastNameInProfileBy = By.cssSelector(".pv-top-card .text-heading-xlarge");
    public By lastNameInProfileBy = By.cssSelector(".pv-text-details__left-panel .text-heading-xlarge");
    private By homeButton = By.cssSelector(".ember-view.global-nav__branding .global-nav__logo");



    //my code to edit profile
    public void clickEditProfile(){
        clickElement(editProfileBy);
    }
    //my code to send text
    public void sendLastName(){
        sendText(lastNameBy , "x");
    }

    //my code to save
    public void clickSave(){
        clickElement(saveButton);
    }

    //my code to find if Save Successfull message is displayed
    public boolean isSaveSuccessDisplayed(){
        return isElementDisplayed(saveToastMessage);
    }

    public String getToastText(){
        return waitForElementText(saveToastMessage);
    }

    public String getLastName(){
        return waitForInputElementValue(lastNameBy);
    }

    public String getFirstName(){
        return waitForInputElementValue(firstNameBy);
    }

    public String getLastNameFromProfilePage(){
        return getText(lastNameInProfileBy);
    }

    public void clickHomeButton(){
        clickElement(homeButton);
    }

}
