package com.srabon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By inventoryItems = By.className("inventory_item");

    public HomePage(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isOnInventoryPage() {
        return wait.until(ExpectedConditions.urlContains("inventory"));
    }

    public boolean productsAreVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryItems)).isDisplayed();
    }
}
