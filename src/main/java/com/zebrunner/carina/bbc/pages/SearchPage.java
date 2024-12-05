package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase{
    @FindBy(xpath = "//div[@data-testid='liverpool-card']")
    private List<ExtendedWebElement> articles;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> getArticleHeadlines() {
        return articles.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    @Override
    public boolean isPageOpened() {
        return !articles.isEmpty();
    }
}
