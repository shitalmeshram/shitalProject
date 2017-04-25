package com.bidqa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import static org.testng.AssertJUnit.assertTrue;


/**
 * Created by hishailesh77 on 4/24/2017.
 */
public class TestRunner {

    private WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
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
    public void LoginTest() {
        //Submit Login page
        LoginTestPage loginTestPage = PageFactory.initElements(driver,LoginTestPage.class);

       System.out.println("Assert Result:- ");
        Assert.assertTrue(loginTestPage.getLoginTitle().contains("Login - BidQA"));
        loginTestPage.EnterUserName("mickey");
        loginTestPage.EnterPassword("abcd");
        loginTestPage.ClickSignInBtn();
    }

    @Test(priority = 3)
    public void MyAccountDisputeTest(){
        MyAccountPage myAccountPage = PageFactory.initElements(driver,MyAccountPage.class);
        myAccountPage.ClickDisputeLink();
    }

    @Test(priority = 4)
    public void DisputePageTest() {
        DisputePage disputePage = PageFactory.initElements(driver, DisputePage.class);
        disputePage.EnterTheText("Hello there!");
        disputePage.ClickCreateDisputeBtn();
    }

        @Test(priority = 5)
        public void MyAccountPersonalInfoTest(){
            MyAccountPage myAccountPage = PageFactory.initElements(driver,MyAccountPage.class);
            myAccountPage.ClickPersonalInfoLink();
        }

@Test(priority = 6)
public void PersonalInfoTest() throws InterruptedException {
    PersonalInfo personalInfo = PageFactory.initElements(driver, PersonalInfo.class);
    personalInfo.SelectCountry("Bahamas");
    personalInfo.SelectTimezone("Accra");
    personalInfo.EnterText("How are you?");
    Thread.sleep(2000);
    personalInfo.ClickSaveBtn(driver);
}

    @Test(priority = 7)
    public void LogOutTest(){
        MyAccountPage myAccountPage = PageFactory.initElements(driver,MyAccountPage.class);
        myAccountPage.ClickLogOutLink();
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
//Close the browser
     Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

}
