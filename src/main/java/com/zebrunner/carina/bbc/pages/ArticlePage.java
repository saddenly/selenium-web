package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.bbc.components.desktop.HeaderDesktop;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ArticlePageBase.class)
public class ArticlePage extends ArticlePageBase {
    @FindBy(xpath = "//header")
    private HeaderDesktop header;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SavedItemsPageBase openSavedItemsPage() {
        header.openProfileDropdown();
        return header.openSavedArticlesPage();
    }
}
