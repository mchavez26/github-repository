package com.encora.schools.automation.test;

import com.encora.schools.automation.framework.DriverHandler;
import com.encora.schools.automation.pages.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class LandingTest extends LoggedInBaseTest {


    private SearchResultsPage searchResultsPage;

    LandingTest(){
        super("",""); // executes constructor of basetest
        searchResultsPage = new SearchResultsPage(DriverHandler.getDriver());
    }

    @Test
    public void loginToLinkedin_andEdit(){
        homePage.clickProfile();
        profilePage.clickEditProfile();
        String currentLastName = profilePage.getLastName();
        String currentFirstName = profilePage.getFirstName(); // have to use this to compare with the saved complete name
        String expectedSavedCompleteName = currentFirstName + " " + currentLastName + "x";
        profilePage.sendLastName();
        profilePage.clickSave();
        Assert.assertEquals(profilePage.getToastText(), "Save was successful.");
        DriverHandler.getDriver().get("https://www.linkedin.com/home");
        homePage.clickProfile(); //wait for profile to load here
        //WebDriverWait wait = new WebDriverWait(DriverHandler.getDriver(), 5); //include this in a new method (parameter would be URL)
        //wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.lastNameInProfileBy));
        profilePage.waitForElement(profilePage.lastNameInProfileBy); //NEW
        DriverHandler.getDriver().navigate().refresh(); ////// I need to pause this
        String savedLastName = profilePage.getLastNameFromProfilePage();
        Assert.assertEquals(savedLastName, expectedSavedCompleteName);
        //DriverHandler.getDriver().get("https://www.linkedin.com/home");

    }

    @Test
    public void sendMessageToUser() {
        homePage.clickSearchBar();
        homePage.sendSearchUser(); //aquí me quedé, no se como encontrar el elemento del resultado del search, ya pudimos
        WebElement myWebElement = homePage.getSearchResultWithText("Edwin Manuel Chávez Arzola");
        myWebElement.click();
        searchResultsPage.clickViewFullProfileButton(); //pause here
        //WebDriverWait wait = new WebDriverWait(DriverHandler.getDriver(), 5); //include this in a new method (parameter would be URL)
        final String regex = "https:\\/\\/www\\.linkedin\\.com\\/in\\/([^\\/]+)\\/";
        //final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        //wait.until(ExpectedConditions.urlMatches("https://www.linkedin.com/in/edwin-manuel-ch%C3%A1vez-arzola-629418124/"));
        homePage.waitForUrl(regex); //NEW
        //searchResultsPage.waitForPageLoaded(DriverHandler.getDriver());
        String expectedUserURL = "https://www.linkedin.com/in/edwin-manuel-ch%C3%A1vez-arzola-629418124/";
        String currentUserURL = DriverHandler.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUserURL, expectedUserURL);

    }
    //@Test
    //public void Landing_UserNavigatesToProductURL(){
    //    Assert.assertTrue(landingPage.isLogoDisplayed(), "Logo is displayed.");
    //    Assert.assertTrue(landingPage.isSearchboxDisplayed(), "Searchbox is displayed.");
    //    Assert.assertTrue(landingPage.isCartPreviewDisplayed(), "Cart preview is displayed");
    //}


}
