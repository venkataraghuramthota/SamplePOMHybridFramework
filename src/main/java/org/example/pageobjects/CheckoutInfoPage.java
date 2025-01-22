package org.example.pageobjects;

import org.example.base.TestBase;
import org.example.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CheckoutInfoPage extends TestBase
{
    public CheckoutInfoPage() throws IOException
    {

        PageFactory.initElements(driver, this);
    }



    @FindBy (id="first-name")
    WebElement firstName;

    @FindBy (id="last-name")
    WebElement lastName;

    @FindBy (id="postal-code")
    WebElement zipCode;

    @FindBy (xpath = "//input[@type='submit']")
    WebElement submitButton;

    public void enterCheckoutInfo(String firstname, String lastname, String zip) throws IOException {

        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        zipCode.sendKeys(zip);
        TestUtil.takeScreenshot();
        submitButton.click();

    }

}

