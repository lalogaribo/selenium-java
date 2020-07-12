package com.nearsoft.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBar extends MainComponent {

    @FindBy(id = "store_nav_search_term")
    private WebElement searchBox;

    public SearchBar(WebDriver driver) {
        super(driver);
    }

    public void enterSearch(String keyword) {
        this.searchBox.clear();
        this.searchBox.sendKeys(keyword);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((driver) -> this.searchBox.isDisplayed());
    }
}
