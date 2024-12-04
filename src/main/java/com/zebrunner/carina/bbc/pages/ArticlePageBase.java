package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ArticlePageBase extends AbstractPage {
    public ArticlePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getHeaderText();

    public abstract String getPublicationTime();

    public abstract void saveArticle();

    public abstract SavedItemsPageBase openSavedPage();
}
