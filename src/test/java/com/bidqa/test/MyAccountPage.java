package com.bidqa.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by hishailesh77 on 4/24/2017.
 */
public class MyAccountPage {
    //Dispute link
    @FindBy(how = How.XPATH, using = ".//*[@id='my-account-admin-menu']/li[6]/a")
    private WebElement lnkDispute;

    //LogOut link
    @FindBy(how = How.XPATH, using = ".//*[@id='cssmenu']/ul/li[8]/a")
    private WebElement lnkLogOut;

    //Personal Info link
    @FindBy(how = How.XPATH, using = ".//*[@id='my-account-admin-menu']/li[4]/a")
    private WebElement lnkPersonalInfo;

    //Click Dispute link
    public void ClickDisputeLink() {
        lnkDispute.click();
    }

    //Click Personal Info link
    public void ClickPersonalInfoLink() {
        lnkPersonalInfo.click();
    }

    //Click LogOut link
    public void ClickLogOutLink() {
        lnkLogOut.click();
    }
}