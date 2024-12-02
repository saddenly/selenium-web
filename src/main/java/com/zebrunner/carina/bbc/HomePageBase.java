package com.zebrunner.carina.bbc;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void enterSearchQuery(String query);

    public abstract SearchPageBase clickSearch();

    public abstract void openSearchForm();

    public abstract void agreeToCookies();

    public abstract List<ExtendedWebElement> getNavigationItems();

    public abstract VideoPageBase openVideoPage();

    public abstract ArticlePageBase openFirstArticle();

    public abstract void changeLanguageToRussian();

    public abstract LoginPageBase openLoginPage();

    public abstract boolean isProfileButtonVisible();

    public abstract NewsletterPageBase openNewsletterPage();
}
