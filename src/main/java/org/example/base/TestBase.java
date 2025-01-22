package org.example.base;

import org.example.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase
{
   public static WebDriver driver;
   public static Properties prop;
   public FileInputStream ip;

    public TestBase() throws IOException {
        prop = new Properties();
        ip = new FileInputStream("/Users/raghuramthota/IdeaProjects/SampleJavaProject/src/main/java/org/example/config/config.properties");
        prop.load(ip);
    }

    public static void initialization() throws IOException {
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if (browserName.equals("firefox"))
        {
         driver = new FirefoxDriver();
        }
        else
        {
            driver = new EdgeDriver();
        }



        // Create the event listener
        WebEventListener listener = new WebEventListener();

        // Decorate the WebDriver with the listener
        WebDriver decoratedDriver = new EventFiringDecorator(listener).decorate(driver);

        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        driver = decoratedDriver;



        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));



    }

}
