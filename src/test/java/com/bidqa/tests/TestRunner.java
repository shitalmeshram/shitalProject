package com.bidqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import com.bidqa.pages.*;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;


/**
 * Created by hishailesh77 on 4/24/2017.
 */
public class TestRunner {

    private WebDriver driver;
    @BeforeClass
    @Parameters({"driverName","driverLocation","browser"})
    public void beforeClass(String driverName,String driverLocation,String browser) {
        System.setProperty(driverName, driverLocation);
        if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }

        driver.navigate().to("http://test.bidqa.com");
        driver.manage().window().maximize();
    }

    @Test(priority=1)
    public void WelcomeTest() {
        //Initialize Login Page
        WelcomeTestPage welcomeTestPage = PageFactory.initElements(driver, WelcomeTestPage.class);
        welcomeTestPage.ClickLoginLink();

    }

    @Test(priority=2)
    @Parameters({"userName","passWord"})
    public void LoginTest(String userName,String passWord) throws InterruptedException {
        //Submit Login page
        LoginTestPage loginTestPage = PageFactory.initElements(driver,LoginTestPage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       System.out.println("Assert Result:- ");
       // Assert.assertTrue(loginTestPage.getLoginTitle().contains("Login - BidQA"));
        loginTestPage.EnterUserName(userName);
        loginTestPage.EnterPassword(passWord);
        loginTestPage.ClickSignInBtn();
    }

    @Test(priority = 3)
    public void MyAccountDisputeTest() throws InterruptedException {
        MyAccountPage myAccountPage = PageFactory.initElements(driver,MyAccountPage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        myAccountPage.ClickDisputeLink();
    }

    @Test(priority = 4)
    @Parameters("enterText")
    public void DisputePageTest(String enterText) throws InterruptedException {
        DisputePage disputePage = PageFactory.initElements(driver, DisputePage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        disputePage.EnterTheText(enterText);
        disputePage.ClickCreateDisputeBtn();
    }

        @Test(priority = 5)
        public void MyAccountPersonalInfoTest() throws InterruptedException {
            MyAccountPage myAccountPage = PageFactory.initElements(driver,MyAccountPage.class);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            myAccountPage.ClickPersonalInfoLink();
        }

@Test(priority = 6)
@Parameters({"country","timeZone","textArea"})
public void PersonalInfoTest(String country,String timeZone,String textArea ) throws InterruptedException {
    PersonalInfo personalInfo = PageFactory.initElements(driver, PersonalInfo.class);
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    personalInfo.SelectCountry(country);
    personalInfo.SelectTimezone(timeZone);
    personalInfo.EnterText(textArea);
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    personalInfo.ClickSaveBtn(driver);
}

    @Test(priority = 7)
    public void LogOutTest(){
        MyAccountPage myAccountPage = PageFactory.initElements(driver,MyAccountPage.class);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        myAccountPage.ClickLogOutLink();
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
//Close the browser
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.close();
        driver.quit();
    }

}
