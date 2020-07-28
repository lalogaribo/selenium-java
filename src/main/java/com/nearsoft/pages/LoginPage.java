package com.nearsoft.pages;

import com.nearsoft.components.Login;
import com.nearsoft.components.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private Login loginPage;
    private NavigationBar navigationBar;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.loginPage = PageFactory.initElements(driver, Login.class);
        this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
    }

    public void goTo() {
        this.driver.get("https://store.steampowered.com/");
    }

    public Login getLoginPage() {
        return loginPage;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }
}
