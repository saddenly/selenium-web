package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.bbc.components.Header;
import com.zebrunner.carina.bbc.components.Navigation;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void agreeToCookies();

    public abstract ArticlePageBase openFirstArticle();

    public abstract void changeLanguageToRussian();

    public abstract Header getHeader();

    public abstract Navigation getNavigation();
}
