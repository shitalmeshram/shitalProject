package com.bidqa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by hishailesh77 on 4/24/2017.
 */
public class PersonalInfo {
    //Define Country Field
    @FindBy(how = How.XPATH, using = ".//*[@id='personal_information_form']/div[1]/div/ul/div[3]/div/select")
    private WebElement selectCountry;

    //Define Timezone Field
    @FindBy(how = How.XPATH, using = ".//*[@id='user_timezone']")
    private WebElement selectTimezone;

    //Define Description Field
    @FindBy(how = How.XPATH, using = ".//*[@id='mceu_27']")
    private WebElement txtEnter;

    //Define Save button
    @FindBy(how = How.NAME, using = "save-info")
    private WebElement btnSave;

    //Select Country from drop down
    public void SelectCountry(String country) throws InterruptedException {
        Select dropdown1 = new Select(selectCountry);
        dropdown1.selectByVisibleText(country);
        Thread.sleep(2000);
    }

    //Select TimeZone from drop down
    public void SelectTimezone(String timezone) throws InterruptedException {
        Select dropdown2 = new Select(selectTimezone);
        dropdown2.selectByVisibleText(timezone);
        Thread.sleep(2000);
    }

    //Enter text in textarea
    public void EnterText(String textenter){
        txtEnter.sendKeys(textenter);
    }

    //Save Click Method
    public void ClickSaveBtn(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(btnSave);
        actions.perform();
        btnSave.click();
    }
}
