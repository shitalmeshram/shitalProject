package com.bidqa.test;

import java.util.concurrent.TimeUnit;
//--
import org.openqa.selenium.By;
//--
import org.openqa.selenium.WebDriver;
//--
import org.openqa.selenium.WebElement;
//--
import org.openqa.selenium.firefox.FirefoxDriver;
//--
import org.testng.Assert;
//--
import org.testng.annotations.AfterClass;
//--
import org.testng.annotations.BeforeClass;
//--
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest

{
    private WebDriver driver;

   /* @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver","D:\\TEMP-DOWNLOADS\\geckodriver-v0.16.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }*/

  /*  @Test
    public void verifySearchButton() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.google.com");

        String search_text = "Google Search";
        WebElement search_button = driver.findElement(By.name("btnK"));

        String text = search_button.getAttribute("value");

        Assert.assertEquals(text, search_text, "Text not found!");
    } */

  @Test
    public void runTest(){
      LoginTest lt= new LoginTest();
      lt.loginVerification();
  }
}