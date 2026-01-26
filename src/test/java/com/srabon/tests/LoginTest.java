package com.srabon.tests;

import com.srabon.base.BaseTest;
import com.srabon.pages.HomePage;

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

    }


}
