package com.srabon.tests;

import com.srabon.base.BaseTest;
import com.srabon.pages.HomePage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 0)
    public void validUserLogin(){
        HomePage homePage = logingIntoPage.logIn("standard_user", "secret_sauce");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),"Login failed: inventory page is not loaded");
    }


    @Test(priority = 1, dependsOnMethods = "validUserLogin")
    public void productAreVisibleAfterLogin(){
        HomePage homePage =logingIntoPage.logIn("standard_user", "secret_sauce");
    Assert.assertTrue(
           // driver.findElement(By.className("inventory_item")).size()>0
            homePage.productsAreVisible(), "Products are Not visible after login"
    );

    }

    @Test(priority = 2)
    public void invalidUserLogin(){
        logingIntoPage.logIn("wrong_user", "wrong_password");

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
