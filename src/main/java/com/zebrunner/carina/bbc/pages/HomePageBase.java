package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.bbc.components.Header;
import com.zebrunner.carina.bbc.components.Navigation;
import com.zebrunner.carina.bbc.enums.Language;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void agreeToCookies();

    public abstract ArticlePageBase openArticle(int index);

    public abstract String getArticleHeadline(int index);

    public abstract void changeLanguage(Language language);

    public abstract Header getHeader();

    public abstract Navigation getNavigation();

    public abstract ExtendedWebElement getOtherLanguagesButton();

    public abstract ExtendedWebElement getLanguageButton();
}
