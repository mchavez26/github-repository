package com.encora.schools.automation.test;

import com.encora.schools.automation.framework.DriverHandler;
import com.encora.schools.automation.pages.*;
import com.encora.schools.automation.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class LoggedInBaseTest extends BaseTest {

    protected LandingPage landingPage;
    protected SignInPage signInPage;
    protected HomePage homePage;
    protected ProfilePage profilePage;
    //protected SearchResultsPage searchResultsPage;

    LoggedInBaseTest(String email, String password){
        super();
        this.signInPage = new SignInPage(email, password);
        this.landingPage = new LandingPage();
        this.homePage = new HomePage();
        this.profilePage = new ProfilePage();
    }

    @BeforeSuite // use for login //assert the login here
    public void testSetup(){
        DriverHandler.getDriver().get("https://www.linkedin.com/home");
        landingPage.clickSignin();
        signInPage.sendEmail();
        signInPage.sendPassword();
        signInPage.clickSignin2();
        Assert.assertTrue(homePage.isWelcomeDisplayed(), "Welcome is displayed.");

    }

    @AfterMethod
    public void goHome(){
        profilePage.clickHomeButton();
    }

    @AfterSuite //despues de ejecutar toda la suite, se ejecuta el siguiente metodo
    public void logOut(){
        profilePage.clickHomeButton();
        homePage.waitForElement(homePage.welcomeButton);
        homePage.clickMeButton();
        homePage.clickSignOutButton();
        //homePage.clickSignOutButton2();
        String expectedHomeURL = "https://www.linkedin.com/home";
        //wait = new WebDriverWait(DriverHandler.getDriver(), 5); //include this in a new method (parameter would be URL)
        //wait.until(ExpectedConditions.presenceOfElementLocated(landingPage.signInBy));
        homePage.waitForElement(landingPage.signInBy); //NEW
        String currentHomeURL = DriverHandler.getDriver().getCurrentUrl(); ///// I need to pause this // also wait here
        Assert.assertEquals(currentHomeURL, expectedHomeURL);
        DriverHandler.teardown();
        DriverHandler.closeDriver();
    }


}
