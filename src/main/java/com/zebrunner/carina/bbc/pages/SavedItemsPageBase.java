package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SavedItemsPageBase extends AbstractPage {
    public SavedItemsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ExtendedWebElement getSavedItem();
}
