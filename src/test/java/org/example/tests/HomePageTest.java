package org.example.tests;

import org.example.base.TestBase;
import org.example.pageobjects.HomePage;
import org.example.pageobjects.LoginPage;
import org.example.pageobjects.LogoutPage;
import org.example.pageobjects.CheckOutPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase
{

    public LoginPage loginPage;
    public HomePage homePage;
    public LogoutPage logoutPage;
    public CheckOutPage checkOutPage;
    String cartCount;
    public HomePageTest() throws IOException {
        super();

    }
    @BeforeMethod
    public void setup() throws IOException {
        initialization();
        LoginPage loginPage=new LoginPage();
        LogoutPage logoutPage=new LogoutPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    @Test
    public void testHomepageLogoDisplay() throws IOException {

        boolean flag = homePage.homepageLogoDisplay();
        Assert.assertTrue(flag);
    }

    @Test
    public void testCartCount()
    {
        cartCount = homePage.addToCartCount();
        Assert.assertEquals(cartCount,"1");
    }
 @Test
 public void testAddToCart() throws IOException {
    checkOutPage = homePage.addToCart();
 }
    @Test
    public void testLogout() throws IOException
    {
        logoutPage = homePage.logout();
        boolean flag1 = logoutPage.logoutLogoDisplay();
        Assert.assertTrue(flag1);
    }


    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
