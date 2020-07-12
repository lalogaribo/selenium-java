package com.nearsoft.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends MainComponent {
    @FindBy(className = "store_nav")
    private WebElement navBar;

    @FindBy(id = "foryou_tab")
    private WebElement yourStoreOption;

    @FindBy(id = "genre_tab")
    private WebElement browseOption;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void goToYourStore() {
        this.yourStoreOption.click();
    }

    public void goToBrowse() {
        this.browseOption.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((driver) -> this.navBar.isEnabled());

    }
}
