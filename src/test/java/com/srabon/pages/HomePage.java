package com.srabon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By pageTitle= By.className("title");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }



    public boolean homePageDisplayed() {
        return driver.getCurrentUrl().contains("inventory");
    }

    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
