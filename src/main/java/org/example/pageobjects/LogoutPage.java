package org.example.pageobjects;

import org.example.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LogoutPage extends TestBase {
    public LogoutPage() throws IOException
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='login_logo']")
    WebElement logoutLogo;

    public boolean logoutLogoDisplay()
    {
        return logoutLogo.isDisplayed();
    }
}
