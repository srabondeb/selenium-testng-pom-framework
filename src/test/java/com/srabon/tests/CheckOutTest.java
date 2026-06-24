package com.srabon.tests;

import com.srabon.base.BaseTest;
import com.srabon.pages.ProductsPage;
import com.srabon.pages.CartPage;
import com.srabon.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {

    @Test(enabled = false) // TODO: re-enable after fixing checkout-step-one render timing

    public void completeCheckoutShowsConfirmation() {
        ProductsPage productsPage = loginPage.logIn("standard_user", "secret_sauce");
        productsPage.addBackpackToCart();
        CartPage cartPage = productsPage.goToCart();
        CheckoutPage checkoutPage = cartPage.proceedToCheckout();
        checkoutPage.enterCustomerInfo("Srabon", "Debnath", "20109");
        checkoutPage.finish();
        Assert.assertEquals(checkoutPage.getConfirmationMessage(), "Thank you for your order!",
                "Checkout confirmation message did not appear");
    }
}