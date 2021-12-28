package com.encora.schools.automation.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverHandler {
    private static WebDriver webDriver;

    public static WebDriver getDriver() {
        if (webDriver == null){
            webDriver = setupDriver();
        }
        return webDriver;
    }

    private static WebDriver setupDriver(){
        WebDriverManager.chromedriver().setup();
        // setup
        //ChromeOptions chromeOptions = new ChromeOptions();
        webDriver = new ChromeDriver();
        webDriver.manage().deleteAllCookies();
        return webDriver;
    }

    public static void teardown() {
        if (webDriver != null){
            webDriver.manage().deleteAllCookies();
        }
    }

    public static void closeDriver(){
        if (webDriver != null){
            webDriver.quit();
        }
    }
}
