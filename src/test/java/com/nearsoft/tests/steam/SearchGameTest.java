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
    public void searchGame(String keyword, String genre, String developer, String publisher, int index) {
        steamMainPage.goTo();
        Assert.assertTrue(steamMainPage.getSearchBar().isDisplayed());
        steamMainPage.getSearchBar().enterSearch(keyword);
        Assert.assertTrue(steamMainPage.getSearchBar().getSearchInput().equals(keyword));
        Assert.assertTrue(steamMainPage.getResults().isDisplayed());
        steamMainPage.getResults().clickGameByIndex(index);
        Assert.assertTrue(gameDetail.getGameDetail().isDisplayed());
        Assert.assertEquals(keyword, gameDetail.getGameDetail().getGameHeader());
        Assert.assertTrue(gameDetail.getGameDetail().gameDetailsIsDisplayed());
        js.executeScript("arguments[0].scrollIntoView();", gameDetail.getGameDetail().gameDetailsBlock);
        Assert.assertEquals(genre, gameDetail.getGameDetail().getGenre(genre));
        Assert.assertEquals(developer, gameDetail.getGameDetail().getDeveloperName(developer));
        Assert.assertEquals(publisher, gameDetail.getGameDetail().getPublisher(publisher));
    }

    @DataProvider
    public Object[][] gameData() {
        return new Object[][]{
                {"Portal 2", "Action", "Valve", "Valve", 1},
                {"Age of Empires II: Definitive Edition", "Strategy", "Forgotten Empires", "Xbox Game Studios", 1}
        };
    }
}
