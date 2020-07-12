package com.nearsoft.tests.steam;

import com.nearsoft.pages.SteamMainPage;
import com.nearsoft.tests.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchGameTest extends BaseTest {

    SteamMainPage steamMainPage;

    @BeforeTest
    public void pagesSetup() {
        this.steamMainPage = new SteamMainPage(driver);
    }

    @Test
    public void searchGame() {
        steamMainPage.goTo();
        steamMainPage.getSearchBar().enterSearch("portal");
    }
}
