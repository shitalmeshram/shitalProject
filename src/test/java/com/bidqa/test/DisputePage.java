package com.bidqa.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by hishailesh77 on 4/24/2017.
 */
public class DisputePage {
    //Define textarea
    @FindBy(how = How.XPATH, using = ".//*[@id='content']/div[1]/div/div[2]/form/div/div[2]/div/textarea")
    private WebElement txtArea;

    //Define Create Dispute button
    @FindBy(how = How.XPATH, using = ".//*[@id='content']/div[1]/div/div[2]/form/div/div[3]/div/input")
    private WebElement btnCreateDispute;

    //Enter text in textarea
    public void EnterTheText(String entertext){
        txtArea.sendKeys(entertext);
    }

    //Define Create Dispute Click Method
    public void ClickCreateDisputeBtn() {
        btnCreateDispute.click();
    }
}
