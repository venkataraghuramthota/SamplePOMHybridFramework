package org.example.tests;

import org.example.base.TestBase;
import org.example.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckOutPageTest extends TestBase
{
    public CheckOutPageTest() throws IOException {
        super();
    }
HomePage homePage = new HomePage();
    CheckOutPage checkOutPage = new CheckOutPage();
    CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage();

    @BeforeMethod
    public void setup() throws IOException {
        initialization();
        LoginPage loginPage=new LoginPage();
        LogoutPage logoutPage=new LogoutPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        checkOutPage = homePage.addToCart();
    }

    @Test
    public void testCheckOutButtonDisplay()
    {
        Assert.assertTrue(checkOutPage.checkOutIconDisplay());
    }
    @Test
    public void testClickCheckout() throws IOException {
        checkOutPage.clickCheckout();
    }
@AfterMethod
 public void tearDown()
{
    driver.quit();
}


}


