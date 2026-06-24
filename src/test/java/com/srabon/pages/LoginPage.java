package com.srabon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By userNameField= By.id("user-name");
    private By passwordField= By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage  = By.cssSelector("[data-test='error']");


    public LoginPage(WebDriver driver,WebDriverWait wait){
        this.wait = wait;
        this.driver=driver;
    }

    public void enterUserName(String userName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField)).sendKeys(userName);
    }

    public void enterPassword(String password){

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);

    }

    public void clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

    }

    public ProductsPage logIn(String userName, String password){
        enterUserName(userName);
        enterPassword(password);
        clickLogin();
        return new ProductsPage(driver,wait);
    }

    public boolean isErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }
    public boolean isLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
    }

}
