package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.bbc.components.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class ArticlePageBase extends LoggedInPage {
    @FindBy(xpath = "//div[contains(@data-component, 'headline-block')]/h1")
    private ExtendedWebElement headline;

    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(xpath = "//time")
    private ExtendedWebElement time;

    @FindBy(xpath = "//button[@data-testid='saveButton']")
    private ExtendedWebElement saveButton;

    public ArticlePageBase(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return headline.getText();
    }

    public String getPublicationTime() {
        return time.getText();
    }

    public void saveArticle() {
        saveButton.click();
    }

    public Header getHeader() {
        return header;
    }
}
