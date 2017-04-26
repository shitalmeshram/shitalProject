package com.bidqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by hishailesh77 on 4/24/2017.
 */
public class LoginTestPage {
    //Define Username textbox
    @FindBy(how = How.ID, using = "log")
    private WebElement txtUserName;

    //Define Password textbox
    @FindBy(how = How.ID, using = "login_password")
    private WebElement txtPassword;

    //Define Sign In button
    @FindBy(how = How.ID, using = "submits")
    private WebElement btnSignIn;

    //Get Login Title
    @FindBy(how = How.XPATH, using = ".//*[@id='wrapper']/div[2]/div/div")
    private WebElement loginTitle;


    //Enter text in Username textbox
    public void EnterUserName(String usernametext){
        txtUserName.sendKeys(usernametext);
    }

    //Enter the password
    public void EnterPassword(String pwd){
        txtPassword.sendKeys(pwd);
    }
    //Define Login Button Click Method
    public void ClickSignInBtn() {
        btnSignIn.click();
    }

    public String getLoginTitle(){

        return   loginTitle.getText();

    }

}
