package com.zebrunner.carina.bbc.components;

import com.zebrunner.carina.bbc.pages.ArticlePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EdinburghArticleCard extends AbstractUIObject {

    @FindBy(xpath = ".//h2[@data-testid='card-headline']")
    private ExtendedWebElement cardHeadline;

    @FindBy(xpath = ".//p[@data-testid='card-description']")
    private ExtendedWebElement cardDescription;

    @FindBy(xpath = ".//span[@data-testid='card-metadata-lastupdated']")
    private ExtendedWebElement cardLastUpdated;

    public EdinburghArticleCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ArticlePageBase openArticlePage() {
        return initPage(getDriver(), ArticlePageBase.class);
    }

    public ExtendedWebElement getCardHeadline() {
        return cardHeadline;
    }

    public ExtendedWebElement getCardDescription() {
        return cardDescription;
    }

    public ExtendedWebElement getCardLastUpdated() {
        return cardLastUpdated;
    }
}
