package com.encora.schools.automation.pages;

import com.encora.schools.automation.framework.DriverHandler;
import com.sun.istack.internal.localization.NullLocalizable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    private WebDriver webDriver = DriverHandler.getDriver();

    BasePage(){
        //this.webDriver = webDriver;
    }

    protected WebDriver getWebDriver(){
        return webDriver;
    }

    protected WebElement findElement(By locator){
        return getWebDriver().findElement(locator);
    }

    protected List<WebElement> findElements(By locator){
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return getWebDriver().findElements(locator);
    }

    //my code to click
    protected void clickElement(By locator){
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        //findElement(locator).click();
    }

    //my code to get text from textbox
    protected String getText(By locator){
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return findElement(locator).getText();
    }

    protected void sendText(By locator, String text){
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.sendKeys(text);
        //findElement(locator).sendKeys(text);
    }

    protected boolean isElementDisplayed(By locator){
        try{
            //WebDriverWait wait = new WebDriverWait(webDriver, 5);
            WebElement element = this.waitForElement(locator);//wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return element.isDisplayed();
            //return findElement(locator).isDisplayed();
        } catch (NoSuchElementException ex){
            return false;
        }


    }

    public WebElement waitForElement(By locator){
        try{
            WebDriverWait wait = new WebDriverWait(webDriver, 5);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return element;
            //return findElement(locator).isDisplayed();
        } catch (NoSuchElementException ex){
            return null;
        }
    }

    protected String waitForElementText(By locator){
        try{
            //WebDriverWait wait = new WebDriverWait(webDriver, 5);
            WebElement element = this.waitForElement(locator);
            return element.getText();
            //return findElement(locator).isDisplayed();
        } catch (NoSuchElementException ex){
            return null;
        }
    }

    protected String waitForInputElementValue(By locator){
        try{
            //WebDriverWait wait = new WebDriverWait(webDriver, 5);
            WebElement element = this.waitForElement(locator);
            return element.getAttribute("value");
            //return findElement(locator).isDisplayed();
        } catch (NoSuchElementException ex){
            return null;
        }
    }

    public void waitForPageLoaded(WebDriver driver)
    {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>()
                {
                    public Boolean apply(WebDriver driver)
                    {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        Wait<WebDriver> wait = new WebDriverWait(driver,30);
        //try
        //{
            wait.until(expectation);
        //}
        //catch(Throwable error)
        //{
            //assertFalse("Timeout waiting for Page Load Request to complete.",true);
        //}
    }

    //public void waitForElement(By locator){
    //  WebDriverWait wait = new WebDriverWait(DriverHandler.getDriver(), 5); //include this in a new method (parameter would be URL)
    //  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    //}

    public void waitForUrl(String url){
        WebDriverWait wait = new WebDriverWait(DriverHandler.getDriver(), 5); //include this in a new method (parameter would be URL)
        wait.until(ExpectedConditions.urlMatches(url));

    }

}
