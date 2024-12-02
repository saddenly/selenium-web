package com.zebrunner.carina.bbc;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ArticlePageBase.class)
public class ArticlePage extends ArticlePageBase {
    @FindBy(css = "#main-content > article > div.sc-18fde0d6-0.eeiVGB > h1")
    private ExtendedWebElement header;

    @FindBy(css = "#main-content > article > div:nth-child(2) > div > div.sc-2b5e3b35-1.jTEdni > time")
    private ExtendedWebElement time;

    @FindBy(css = "#main-content > article > div:nth-child(2) > div > div.sc-2b5e3b35-1.jTEdni > div > button")
    private ExtendedWebElement saveButton;

    @FindBy(css = "#__next > div > header > div > div.sc-28ab61fc-12.kABLhb > div > div > button")
    private ExtendedWebElement profileDropdown;

    @FindBy(css = "#__next > div > header > div > div.sc-28ab61fc-12.kABLhb > div > div > div > div:nth-child(1) > a")
    private ExtendedWebElement savedButton;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getHeaderText() {
        return header.getText();
    }

    @Override
    public String getPublicationTime() {
        return time.getText();
    }

    @Override
    public void saveArticle() {
        saveButton.click();
    }

    @Override
    public SavedItemsPageBase openSavedPage() {
        profileDropdown.click();
        savedButton.click();
        return initPage(driver, SavedItemsPageBase.class);
    }
}
