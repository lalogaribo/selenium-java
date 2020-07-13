package com.nearsoft.pages;

import com.nearsoft.components.GameDetail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GameDetailPage {
    private WebDriver driver;
    private GameDetail gameDetail;

    public GameDetailPage(WebDriver driver) {
        this.driver = driver;
        this.gameDetail = PageFactory.initElements(driver, GameDetail.class);
    }

    public GameDetail getGameDetail() {
        return gameDetail;
    }
}
