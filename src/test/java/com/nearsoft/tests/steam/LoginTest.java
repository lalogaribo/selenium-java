package com.nearsoft.tests.steam;

import com.nearsoft.pages.LoginPage;
import com.nearsoft.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeTest
    public void setupPages() {
        this.loginPage = new LoginPage(driver);
    }

    @Test(dataProvider = "userData")
    public void loginWithInvalidAccount(String username, String password) {
        loginPage.goTo();
        loginPage.getNavigationBar().clickLogin();
        Assert.assertTrue(loginPage.getLoginPage().isDisplayed());
        loginPage.getLoginPage().loginAccount(username, password);
        Assert.assertTrue(loginPage.getLoginPage().errorMessageDisplayed());
    }

    @DataProvider
    public Object[][] userData() {
        return new Object[][]{
                {"lalo", "Action"},
                {"mendoza", "Strategy"}
        };
    }
}
