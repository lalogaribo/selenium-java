package com.nearsoft.tests.steam;

import com.nearsoft.pages.RegisterPage;
import com.nearsoft.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterAccountTest extends BaseTest {
    RegisterPage registerPage;

    @BeforeTest
    public void setupPages() {
        this.registerPage = new RegisterPage(driver);
    }

    @Test(dataProvider = "invalidData")
    public void createAccount(String email, String emailConfirm, String country) {
        registerPage.goTo();
        registerPage.getNavigationBar().clickLogin();
        Assert.assertTrue(registerPage.getLoginPage().isDisplayed());
        registerPage.getLoginPage().clickRegisterBtn();
        Assert.assertTrue(registerPage.getCreateAccount().isDisplayed());
        registerPage.getCreateAccount().registerAccount(email, emailConfirm, country);

    }


    @DataProvider
    public Object[][] invalidData() {
        return new Object[][]{
                {"egaribo@gmail.com", "egaribo3@gmail.com", "MX"},
                {"mendoza@gmail.com", "mendozaa@gmail.com", "US"}
        };
    }

}
