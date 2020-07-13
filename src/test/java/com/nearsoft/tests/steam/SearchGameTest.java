package com.nearsoft.tests.steam;

import com.nearsoft.pages.GameDetailPage;
import com.nearsoft.pages.SteamMainPage;
import com.nearsoft.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchGameTest extends BaseTest {

    SteamMainPage steamMainPage;
    GameDetailPage gameDetail;

    @BeforeTest
    public void pagesSetup() {

        this.steamMainPage = new SteamMainPage(driver);
        this.gameDetail = new GameDetailPage(driver);
    }

    @Test(dataProvider = "gameData")
    public void searchGame(String keyword) {
        steamMainPage.goTo();
        Assert.assertTrue(steamMainPage.getSearchBar().isDisplayed());

        steamMainPage.getSearchBar().enterSearch(keyword);
        Assert.assertTrue(steamMainPage.getSearchBar().getSearchInput().equals(keyword));
        Assert.assertTrue(steamMainPage.getResults().isDisplayed());
        steamMainPage.getResults().clickGameByIndex(1);
        Assert.assertTrue(gameDetail.getGameDetail().isDisplayed());
        Assert.assertEquals(keyword, gameDetail.getGameDetail().getGameHeader());



    }

    @DataProvider
    public Object[][] gameData() {
        return new Object[][]{
                {"Portal 2"},
                {"Age of Empires II: Definitive Edition"}
        };
    }
}
