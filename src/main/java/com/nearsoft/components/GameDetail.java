package com.nearsoft.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GameDetail extends MainComponent {

    @FindBy(className = "apphub_AppName")
    private WebElement gameNameHeader;

    @FindBy(className = "game_header_image_full")
    private WebElement gameImage;

    @FindBy(css = ".game_details")
    public WebElement gameDetailsBlock;

    public GameDetail(WebDriver driver) {

        super(driver);
    }

    public String getGameHeader() {
        return gameNameHeader.getText();
    }

    public boolean gameDetailsIsDisplayed() {
        return wait.until((driver -> gameDetailsBlock.isDisplayed()));
    }

    public String getDeveloperName(String dev) {
        return wait.until((driver1 -> driver1.findElement(By.xpath("//div[@class='block_content_inner']//a[.=\"" + String.join("\"+", dev) + "\"][1]")).getText()));
    }

    public String getGenre(String genre) {
        return wait.until((driver1 -> driver1.findElement(By.xpath("//a[.=\"" + String.join("\"+", genre) + "\"]")).getText()));
    }

    public String getPublisher(String publisher) {
        return wait.until(driver1 -> driver1.findElement(By.xpath("//div[@class='block_content_inner']//a[.=\"" + String.join("\"+", publisher) + "\"]")).getText());
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((driver -> this.gameNameHeader.isDisplayed()));
    }
}
