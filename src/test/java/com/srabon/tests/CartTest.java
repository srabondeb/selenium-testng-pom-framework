package com.srabon.tests;

import com.srabon.base.BaseTest;
import com.srabon.pages.ProductsPage;
import com.srabon.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addedItemAppearsInCart() {
        ProductsPage productsPage = loginPage.logIn("standard_user", "secret_sauce");
        productsPage.addBackpackToCart();
        CartPage cartPage = productsPage.goToCart();
        Assert.assertTrue(cartPage.getItemNames().contains("Sauce Labs Backpack"),
                "Backpack should appear in the cart after being added");
    }
}