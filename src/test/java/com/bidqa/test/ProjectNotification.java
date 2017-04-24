package com.bidqa.test;
import java.util.concurrent.TimeUnit;
//--
import org.openqa.selenium.By;
//--
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//--
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//--
import org.testng.annotations.*;
//--
//--


public class ProjectNotification {
    private WebDriver driver;

    @BeforeSuite
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver","Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();

    }

    @AfterSuite
    public void afterClass() throws InterruptedException {
         Thread.sleep(5000);
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         driver.quit();
    }


}
