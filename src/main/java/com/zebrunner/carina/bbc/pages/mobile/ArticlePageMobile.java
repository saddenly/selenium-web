package com.zebrunner.carina.bbc.pages.mobile;

import com.zebrunner.carina.bbc.components.mobile.HeaderMobile;
import com.zebrunner.carina.bbc.pages.ArticlePageBase;
import com.zebrunner.carina.bbc.pages.SavedItemsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ArticlePageBase.class)
public class ArticlePageMobile extends ArticlePageBase {
    @FindBy(xpath = "//div[@data-testid='byline-new']/div/button[@data-testid='saveButton']")
    private ExtendedWebElement saveButton;

    @FindBy(xpath = "//header")
    private HeaderMobile header;

    public ArticlePageMobile(WebDriver driver) {
        super(driver);
    }

    @Override
    public void saveArticle() {
        saveButton.click();
    }

    @Override
    public SavedItemsPageBase openSavedItemsPage() {
        return header.openBurgerMenu().openSavedItemsPage();
    }

    @Override
    public ExtendedWebElement getSaveButton() {
        return saveButton;
    }
}
