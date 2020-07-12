package com.nearsoft.components;

import com.sun.tools.javac.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Results extends MainComponent {

    @FindAll({
            @FindBy(css = "#search_suggestion_contents>a")
    })
    private List<WebElement> suggestions;

    public Results(WebDriver driver) {
        super(driver);
    }

    public void clickGameByIndex(int index) {
        this.suggestions.get(index - 1).click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((driver) -> this.suggestions.size() > 0);
    }
}
