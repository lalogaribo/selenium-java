package com.nearsoft.pages;

import com.nearsoft.components.CreateAcount;
import com.nearsoft.components.Login;
import com.nearsoft.components.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    private WebDriver driver;
    private NavigationBar navigationBar;
    private CreateAcount createAccount;
    private Login loginPage;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
        this.createAccount = PageFactory.initElements(driver, CreateAcount.class);
        this.loginPage = PageFactory.initElements(driver, Login.class);
    }

    public void goTo() {
        this.driver.get("https://store.steampowered.com/");
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public CreateAcount getCreateAccount() {
        return createAccount;
    }

    public Login getLoginPage() {
        return loginPage;
    }
}
