package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class SavedItemsPageBase extends AbstractPage {
    @FindBy(xpath = "//div[@data-testid='newcastle-article']")
    private List<ExtendedWebElement> savedItems;

    @FindBy(xpath = "//h2[@data-testid='card-headline']")
    private List<ExtendedWebElement> savedItemsHeadlines;

    public SavedItemsPageBase(WebDriver driver) {
        super(driver);
    }

    public List<ExtendedWebElement> getSavedItems() {
        return savedItems;
    }

    public List<ExtendedWebElement> getSavedItemsHeadlines() {
        return savedItemsHeadlines;
    }
}
