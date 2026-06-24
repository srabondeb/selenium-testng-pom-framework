package com.srabon.base;

import com.srabon.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        //This driverOne for testing login functionality with saucedemo
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        loginPage=new LoginPage(driver,wait);

        //This driverTwo for testing fileUpload, ScreenShoot, DropDown functionality with formy

    }

    @AfterMethod
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

}
