package com.encora.schools.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage{

    private String email, password;

    public SignInPage(String email, String password){

        super();
        this.email = email;
        this.password = password;
    }

    private By usernameBy = By.cssSelector("#username");
    private By passwordBy = By.id("password");
    private By signInButton2By = By.cssSelector(".btn__primary--large");

    //my code to send text
    public void sendEmail(){
        sendText(usernameBy , this.email);
    }

    //my code to send text
    public void sendPassword(){
        sendText(passwordBy , this.password);
    }

    //my code to click sign in 2
    public void clickSignin2(){
        clickElement(signInButton2By);
    }
//change 1
}
