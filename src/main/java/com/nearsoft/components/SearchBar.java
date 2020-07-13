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
        searchBox.clear();
        searchBox.sendKeys(keyword);
    }

    public String getSearchInput() {
        return searchBox.getAttribute("value");
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((driver) -> searchBox.isDisplayed());
    }
}
