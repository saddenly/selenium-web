package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public abstract class SearchPageBase extends AbstractPage {
    @FindBy(xpath = "//div[@data-testid='liverpool-card']")
    private List<ExtendedWebElement> articles;

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public List<String> getArticleHeadlines() {
        return articles.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    public boolean isPageOpened() {
        return !articles.isEmpty();
    }
}
