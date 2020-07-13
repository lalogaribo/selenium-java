package com.nearsoft.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Results extends MainComponent {

    @FindBy(css = "#search_suggestion_contents > a > .match_name")
    private List<WebElement> suggestions;

    public Results(WebDriver driver) {
        super(driver);
    }

    public void clickGameByIndex(int index) {
        suggestions.get(index - 1).click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((driver) -> suggestions.size() > 0);
    }
}
