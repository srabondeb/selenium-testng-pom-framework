package com.srabon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By inventoryItems = By.className("inventory_item");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnInventoryPage() {
        return driver.getCurrentUrl().contains("inventory");
    }

    public boolean productsAreVisible() {
        return driver.findElements(inventoryItems).size() > 0;
    }
}
