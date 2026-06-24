package com.srabon.tests;

import com.srabon.base.BaseTest;
import com.srabon.pages.HomePage;
import org.testng.annotations.DataProvider;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "invalidLogins")
    public Object[][] invalidLogins() {
        return new Object[][] {
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"standard_user", "wrong_password", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "invalidLogins")
    public void invalidLoginShowsError(String username, String password, String expectedError) {
        loginPage.logIn(username, password);
        Assert.assertEquals(loginPage.getErrorMessage(), expectedError,
                "Wrong error message for username: " + username);
    }

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


}
