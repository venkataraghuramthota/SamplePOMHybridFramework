package org.example.pageobjects;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class CheckOutPage extends TestBase
{
    public CheckOutPage() throws IOException {

        PageFactory.initElements(driver,this);
    }
    By checkOut = By.xpath("//a[normalize-space()='CHECKOUT']");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy( xpath = "//a[normalize-space()='CHECKOUT']")
    WebElement checkOutIcon;

    public boolean checkOutIconDisplay()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOut));
        return checkOutIcon.isDisplayed();

    }

    public CheckoutInfoPage clickCheckout() throws IOException
    {

        checkOutIcon.click();
        return new CheckoutInfoPage();
    }




}
