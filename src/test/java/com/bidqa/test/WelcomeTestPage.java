package com.bidqa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by hishailesh77 on 4/24/2017.
 */
public class WelcomeTestPage {

    //Define Login Link
    @FindBy(how=How.XPATH, using=".//*[@id='cssmenu']/ul/li[8]/a")
    private WebElement longinLink;

    //Define Login Button Click Method
    public void ClickLoginLink()
    {
        longinLink.click();
    }


}
