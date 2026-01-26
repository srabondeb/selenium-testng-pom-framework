package com.srabon.tests;

import com.srabon.base.BaseTest;
import com.srabon.pages.HomePage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 0)
    public void validUserLogin(){
        HomePage homePage = loginPage.logIn("standard_user", "secret_sauce");

        Assert.assertTrue(
                homePage.isOnInventoryPage(),"error: inventory Page is not loaded"
        );
    }

    @Test(priority = 1)
    public void productAreVisibleAfterLogin(){
        HomePage homePage =loginPage.logIn("standard_user", "secret_sauce");

    Assert.assertTrue(
            homePage.productsAreVisible(), "Products are Not visible after login"
    );

    }

    @Test(priority = 2)
    public void invalidUserLogin(){
        loginPage.logIn("wrong_user", "wrong_password");

        Assert.assertFalse(
        driver.getCurrentUrl().contains("inventory"),
                "User should remain on login page after invalid login"
    );
        Assert.assertTrue(
                driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed(),
                "Error message should be displayed for invalid login"
        );

    }

}
