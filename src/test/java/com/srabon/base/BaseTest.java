package com.srabon.base;

import com.srabon.pages.LoggingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    protected WebDriver driver;
    protected LoggingPage logingIntoPage;


    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        //because login page is only valid after p
        logingIntoPage=new LoggingPage(driver);
    }

    @AfterClass
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

}
