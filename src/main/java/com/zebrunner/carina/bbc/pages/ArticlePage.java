package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.bbc.components.Header;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ArticlePageBase.class)
public class ArticlePage extends ArticlePageBase {
    @FindBy(xpath = "//div[contains(@data-component, 'headline-block')]/h1")
    private ExtendedWebElement headline;

    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(xpath = "//time")
    private ExtendedWebElement time;

    @FindBy(xpath = "//button[@data-testid='saveButton']")
    private ExtendedWebElement saveButton;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getHeaderText() {
        return headline.getText();
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
    public Header getHeader() {
        return header;
    }
}
