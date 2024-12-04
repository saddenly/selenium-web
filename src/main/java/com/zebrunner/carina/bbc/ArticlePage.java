package com.zebrunner.carina.bbc;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ArticlePageBase.class)
public class ArticlePage extends ArticlePageBase {
    @FindBy(xpath = "//div[contains(@data-component, 'headline-block')]/h1")
    private ExtendedWebElement header;

    @FindBy(xpath = "//time")
    private ExtendedWebElement time;

    @FindBy(xpath = "//button[@data-testid='saveButton']")
    private ExtendedWebElement saveButton;

    @FindBy(xpath = "//button[text()='Your Account']")
    private ExtendedWebElement profileDropdown;

    @FindBy(xpath = "//a[@href='https://www.bbc.com/saved']")
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
