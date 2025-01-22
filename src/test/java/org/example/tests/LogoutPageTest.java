package org.example.tests;

import org.example.base.TestBase;
import org.example.pageobjects.HomePage;
import org.example.pageobjects.LoginPage;
import org.example.pageobjects.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogoutPageTest extends TestBase
{

    LoginPage loginPage;
    HomePage homePage;
    LogoutPage logoutPage;

    public LogoutPageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setup() throws IOException
    {
        initialization();
         loginPage=new LoginPage();
         homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
         logoutPage = homePage.logout();
    }
    @Test
    public void testLogoutFunction()
    {
        boolean flag1 = logoutPage.logoutLogoDisplay();
        Assert.assertTrue(flag1);
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
