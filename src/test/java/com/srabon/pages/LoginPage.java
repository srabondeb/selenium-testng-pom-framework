package com.srabon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userNameField= By.id("user-name");
    private By passwordField= By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void enterUserName(String userName){
        driver.findElement(userNameField).sendKeys(userName);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public void login(String userName, String password){
        enterUserName(userName);
        enterPassword(password);
        clickLogin();
    }

}
