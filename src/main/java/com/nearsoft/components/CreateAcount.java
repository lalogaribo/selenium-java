package com.nearsoft.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateAcount extends MainComponent{

    @FindBy(css = ".game_name")
    private WebElement createAccountHeader;

    @FindBy(id = "email")
    private WebElement emailInputField;

    @FindBy(id = "reenter_email")
    private WebElement confirmEmailInputField;

    @FindBy(id = "country")
    private WebElement countrySelectionDropdown;

    @FindBy(xpath = "//div[@id='captcha_entry_recaptcha']/div[1]//iframe[1]")
    private WebElement captchaFrame;

    @FindBy(id = "recaptcha-anchor-label")
    private WebElement captchaClick;

    @FindBy(id = "i_agree_check")
    private WebElement agreeConditionCheck;

    @FindBy(xpath = "//a[@id='createAccountButton']/span[.='Continue']")
    private WebElement continueBtn;


    public CreateAcount(WebDriver driver) {
        super(driver);
    }

    public void selectCountry(String country){
        Select selectCountry = new Select(countrySelectionDropdown);
        selectCountry.selectByValue(country);
    }

    public void clickCaptcha() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(captchaFrame));
        wait.until((driver -> captchaClick.isDisplayed()));
        captchaClick.click();
        wait.until((driver -> driver.switchTo().defaultContent()));
    }
    public void registerAccount(String email, String confirmationEmail, String country ) {
        emailInputField.sendKeys(email);
        confirmEmailInputField.sendKeys(confirmationEmail);
        selectCountry(country);
        clickCaptcha();
        agreeConditionCheck.click();
        continueBtn.click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((driver -> createAccountHeader.isDisplayed()));
    }
}
