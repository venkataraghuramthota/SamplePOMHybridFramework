package org.example.tests;

import org.example.base.TestBase;
import org.example.pageobjects.HomePage;
import org.example.pageobjects.LoginPage;
import org.openqa.selenium.*;

import java.io.File;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LoginPageTest extends TestBase
{
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() throws IOException
    {
        super();
    }
    @BeforeMethod
    public void setup() throws IOException {
     initialization();
     loginPage = new LoginPage();
     homePage = new HomePage();
    }


    @Test(priority = 1)
    public void logoTestCase()
    {
        boolean flag = loginPage.logoDisplay();
        Assert.assertTrue(flag);
    }
    @Test(priority = 2)
    public void loginTestCase() throws IOException {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        homePage.homepageLogoDisplay();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}

