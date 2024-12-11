package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.bbc.components.desktop.HeaderDesktop;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ArticlePageBase.class)
public class ArticlePage extends ArticlePageBase {
    @FindBy(xpath = "//header")
    private HeaderDesktop header;

    @FindBy(xpath = "//button[@data-testid='saveButton']")
    private ExtendedWebElement saveButton;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void saveArticle() {
        saveButton.click();
    }

    @Override
    public SavedItemsPageBase openSavedItemsPage() {
        header.openProfileDropdown();
        return header.openSavedArticlesPage();
    }

    @Override
    public ExtendedWebElement getSaveButton() {
        return saveButton;
    }
}
