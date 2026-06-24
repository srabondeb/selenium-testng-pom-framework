package com.srabon.tests;

import com.srabon.base.BaseTest;
import com.srabon.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsTest extends BaseTest {

    @Test(priority = 0)
    public void addItemToCartUpdatesBadge() {
        ProductsPage productsPage = loginPage.logIn("standard_user", "secret_sauce");
        productsPage.addBackpackToCart();
        Assert.assertEquals(productsPage.getCartItemCount(), 1,
                "Cart badge should show 1 after adding an item");
    }
    @Test(priority = 1)
    public void sortByPriceLowToHigh() {
        ProductsPage productsPage = loginPage.logIn("standard_user", "secret_sauce");
        productsPage.sortBy("Price (low to high)");
        List<Double> prices = productsPage.getProductPrices();
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);
        Assert.assertEquals(prices, sortedPrices, "Products are not sorted by price low to high");
    }
}