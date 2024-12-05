package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SavedItemsPageBase extends AbstractPage {
    public SavedItemsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<ExtendedWebElement> getSavedItems();

    public abstract List<ExtendedWebElement> getSavedItemsHeadlines();
}
