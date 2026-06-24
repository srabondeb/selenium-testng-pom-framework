package com.srabon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.ArrayList;

public class ProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;


    private By inventoryItems = By.className("inventory_item");
    private By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By sortDropdown = By.className("product_sort_container");
    private By itemPrices = By.className("inventory_item_price");
    private By cartLink = By.className("shopping_cart_link");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");



    public ProductsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void addBackpackToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addBackpackButton)).click();
    }
    public void sortBy(String visibleText) {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(sortDropdown));
        new Select(dropdown).selectByVisibleText(visibleText);
    }

    public List<Double> getProductPrices() {
        List<WebElement> priceElements = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(itemPrices));
        List<Double> prices = new ArrayList<>();
        for (WebElement e : priceElements) {
            prices.add(Double.parseDouble(e.getText().replace("$", "")));
        }
        return prices;
    }

    public int getCartItemCount() {
        String count = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge)).getText();
        return Integer.parseInt(count);
    }

    public boolean isOnInventoryPage() {
        return wait.until(ExpectedConditions.urlContains("inventory"));
    }

    public boolean productsAreVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryItems)).isDisplayed();
    }
    public CartPage goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
        return new CartPage(driver, wait);
    }
    public LoginPage logout() {
        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
        return new LoginPage(driver, wait);
    }
}
