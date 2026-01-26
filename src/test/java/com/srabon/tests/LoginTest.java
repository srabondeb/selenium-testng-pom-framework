package com.srabon.tests;

import com.srabon.base.BaseTest;
import com.srabon.pages.HomePage;
import com.srabon.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 0)
    public void validUserLogin(){
        loginPage.login("standard_user", "secret_sauce");

    }

    @Test
    public void verifyProductTitleDisplayed


}
