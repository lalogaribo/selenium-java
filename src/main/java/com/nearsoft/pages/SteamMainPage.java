package com.nearsoft.pages;

import com.nearsoft.components.Results;
import com.nearsoft.components.SearchBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SteamMainPage {
    private WebDriver driver;
    private SearchBar searchBar;
    private Results results;

    public SteamMainPage(WebDriver driver) {
        this.driver = driver;
        this.searchBar = PageFactory.initElements(driver, SearchBar.class);
        this.results = PageFactory.initElements(driver, Results.class);
    }

    public void goTo() {
        this.driver.get("https://store.steampowered.com/");
    }

    public SearchBar getSearchBar() {
        return this.searchBar;
    }

    public Results getResults() {
        return this.results;
    }
}
