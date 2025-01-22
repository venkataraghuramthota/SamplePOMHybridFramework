package org.example.tests;

import org.example.base.TestBase;
import org.example.pageobjects.*;
import org.example.pageobjects.CheckoutInfoPage;
import org.example.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.util.TestUtil.getTestData;


public class CheckoutInfoTest extends TestBase
{
    public CheckoutInfoTest() throws IOException {
        super();
    }


    public HomePage homePage = new HomePage();
    public CheckOutPage checkOutPage = new CheckOutPage();
    public CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage();
    public LoginPage loginPage;
   public LogoutPage logoutPage=new LogoutPage();
   String sheetName = "contacts";

    @BeforeMethod
    public void setup() throws IOException {
        initialization();
        loginPage=new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
@DataProvider
public Object[][] getCheckoutInfoTestData() throws IOException {
    Object data[][] = getTestData(sheetName);
    return data;
}
    @Test(dataProvider = "getCheckoutInfoTestData")
    public void testCheckOutInfoDetails(String firstname, String lastname, String zip) throws IOException {

        checkOutPage = homePage.addToCart();
        checkoutInfoPage = checkOutPage.clickCheckout();
        checkoutInfoPage.enterCheckoutInfo(firstname,lastname,zip);


    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
