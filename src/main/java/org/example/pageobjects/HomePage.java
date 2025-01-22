package org.example.pageobjects;
import dev.failsafe.internal.util.Assert;
import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage extends TestBase
{
    public String count;
    @FindBy (xpath ="//div[@class='app_logo']")
    WebElement homepageLogo;

    @FindBy (xpath = "//button[contains(text(),'ADD TO CART')][1]")
    WebElement addToCartButton;

    @FindBy (xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
    WebElement cartCount;

    @FindBy (css = "svg[role='img']")
    WebElement cartIcon ;





    @FindBy (xpath = "//button[contains(text(),'Open Menu')]")
    WebElement menuIcon;

    @FindBy (id = "logout_sidebar_link")
    WebElement logout;

    public HomePage() throws IOException
    {
        PageFactory.initElements(driver,this);
    }

    public boolean homepageLogoDisplay()
    {
       return homepageLogo.isDisplayed();

    }

    public String addToCartCount()
    {
        addToCartButton.click();
        count = cartCount.getText();

        return count;

    }

    public CheckOutPage addToCart() throws IOException {

        addToCartButton.click();
        cartIcon.click();


        return new CheckOutPage();

    }


    public LogoutPage logout() throws IOException {
        menuIcon.click();;
        logout.click();
        return new LogoutPage();
    }
}
