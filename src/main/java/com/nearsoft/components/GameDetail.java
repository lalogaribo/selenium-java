package com.nearsoft.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GameDetail extends MainComponent {

    @FindBy(className = "apphub_AppName")
    private WebElement gameNameHeader;

    @FindBy(className = "game_header_image_full")
    private WebElement gameImage;

    public GameDetail(WebDriver driver) {
        super(driver);
    }

    public String getGameHeader() {
        return gameNameHeader.getText();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((driver -> this.gameNameHeader.isDisplayed()));
    }
}
