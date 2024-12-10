package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoggedInPage extends AbstractPage {
    public LoggedInPage(WebDriver driver) {
        super(driver);
    }

    public abstract SavedItemsPageBase openSavedItemsPage();
}
