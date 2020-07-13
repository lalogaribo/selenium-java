package com.nearsoft.tests.steam;

import com.nearsoft.pages.SteamMainPage;
import com.nearsoft.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchGameTest extends BaseTest {

    SteamMainPage steamMainPage;

    @BeforeTest
    public void pagesSetup() {
        this.steamMainPage = new SteamMainPage(driver);
    }

    @Test(dataProvider = "gameData")
    public void searchGame(String keyword) {
        steamMainPage.goTo();
        steamMainPage.getSearchBar().enterSearch(keyword);
        Assert.assertTrue(steamMainPage.getSearchBar().isDisplayed());
        Assert.assertTrue(steamMainPage.getSearchBar().getSearchInput().equals(keyword));
    }

    @DataProvider
    public Object[][] gameData() {
        return new Object[][]{
                {"portal"},
                {"Age of empires"}
        };
    }
}
