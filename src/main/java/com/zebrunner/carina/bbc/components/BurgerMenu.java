package com.zebrunner.carina.bbc.components;

import com.zebrunner.carina.bbc.pages.NewsletterPageBase;
import com.zebrunner.carina.bbc.pages.SearchPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BurgerMenu extends AbstractUIObject {
    @FindBy(xpath = "//button[contains(@data-testid, 'level1NavButton')]")
    private List<ExtendedWebElement> menuItems;

    @FindBy(xpath = "//input[@data-testid='search-input-field']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//button[@data-testid='search-input-search-button']")
    private ExtendedWebElement searchButton;

    public BurgerMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public NewsletterPageBase openNewsletterPage() {
        menuItems.get(13).click();
        return initPage(driver, NewsletterPageBase.class);
    }

    public void enterSearchQuery(String text) {
        searchInput.type(text);
    }

    public SearchPageBase clickSearchButton() {
        searchButton.click();
        return initPage(driver, SearchPageBase.class);
    }
}
