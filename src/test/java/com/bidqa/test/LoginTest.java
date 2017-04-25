package com.bidqa.test;
import java.util.concurrent.TimeUnit;
//--
import org.openqa.selenium.By;
//--
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//--
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//--
import org.testng.annotations.AfterClass;
//--
import org.testng.annotations.BeforeClass;
//--
import org.testng.annotations.Test;


public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
       // System.setProperty("webdriver.gecko.driver","Drivers\\geckodriver.exe");
       // driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @AfterClass
    public void afterClass() throws InterruptedException {

       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       Thread.sleep(5000);
       driver.quit();
    }

    @Test
    public void loginVerification() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://test.bidqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.className("login-awsome")).click();
        driver.findElement(By.id("log")).sendKeys("minnie");
        driver.findElement(By.cssSelector("input[type='password'][name='pwd']")).sendKeys("1234");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='submits']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
@Test(dependsOnMethods = {"loginVerification"})
public void subscribeVerification() throws InterruptedException {


   /* WebElement element= driver.findElement(By.xpath("./[@id='category']"));

    Actions action =new Actions(driver);
    action.moveToElement(element).build().perform();
   // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("./[@id='category']/option[3]")));
    driver.findElement(By.xpath("./*//*[@id='category']/option[3]")).click();
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/

/*   Select se=new Select(element);
   se.selectByVisibleText("Automation – Mobile");*/

    Select dropdown1 = new Select(driver.findElement(By.id("category")));
    dropdown1.selectByVisibleText("Black Box");
    Thread.sleep(2000);

    Select dropdown2 = new Select(driver.findElement(By.id("location")));
    dropdown2.selectByVisibleText("Any location");

    Thread.sleep(2000);
    Select dropdown3 = new Select(driver.findElement(By.name("budgets")));
    dropdown3.selectByVisibleText("Per Hour ($1 - $10)");
    Thread.sleep(2000);
    driver.findElement(By.xpath(".//*[@id='subscribe-form']/button")).click();


    Thread.sleep(5000);

}
  @Test(dependsOnMethods = {"subscribeVerification"})
public void logOut(){

        driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
}
