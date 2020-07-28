package com.nearsoft.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends MainComponent{

    @FindBy(xpath = "//h2[.='Sign in']")
    private WebElement signInHeader;

    @FindBy(id = "input_username")
    private WebElement accountNameInput;

    @FindBy(id = "input_password")
    private WebElement passwordInput;

    @FindBy(xpath = "//span[.='Sign in']")
    private WebElement signInBtn;

    @FindBy(id = "error_display")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[.='Join Steam']")
    private WebElement registerBtn;

    public Login(WebDriver driver) {
        super(driver);
    }

    public void loginAccount(String username, String password){
        accountNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInBtn.click();
    }

    public void clickRegisterBtn() {
        registerBtn.click();
    }

    public boolean errorMessageDisplayed() {
        return wait.until((driver -> errorMessage.isDisplayed()));
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((driver -> signInHeader.isDisplayed()));
    }
}
