package org.example.pageobjects;

import org.example.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginPage extends TestBase
{
    @FindBy (xpath = "//div[@class='login_logo']")
    WebElement logo;

   @FindBy(id = "user-name")
    WebElement userNameEle;

   @FindBy(id = "password")
   WebElement passwordEle;

   @FindBy(id = "login-button")
   WebElement loginButton;


    public LoginPage() throws IOException {

        PageFactory.initElements(driver,this);

    }

    public boolean logoDisplay()
    {
        return logo.isDisplayed();
    }
    public HomePage login(String userName, String password) throws IOException {
        userNameEle.sendKeys(userName);
        passwordEle.sendKeys(password);
        loginButton.click();
      /*  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destFileName = new File("/Users/raghuramthota/IdeaProjects/SampleJavaProject/target/Output/result.png");
        FileHandler.copy(src,destFileName);*/
        return new HomePage();
    }
}
