package com.zebrunner.carina.bbc.components;

import com.zebrunner.carina.bbc.pages.HomePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Navigation extends AbstractUIObject {
    @FindBy(xpath = "//nav[@data-testid='level1-navigation-container']/section/nav/ul/li")
    private List<ExtendedWebElement> navigationList;

    public Navigation(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ExtendedWebElement> getNavigationList() {
        return navigationList;
    }

    public HomePageBase openHomePage() {
        navigationList.get(0).click();
        return initPage(driver, HomePageBase.class);
    }

    public void openNewsPage() {
        navigationList.get(1).click();
    }

    public void openSportPage() {
        navigationList.get(2).click();
    }

    public void openBusinessPage() {
        navigationList.get(3).click();
    }

    public void openInnovationPage() {
        navigationList.get(4).click();
    }

    public void openCulturePage() {
        navigationList.get(5).click();
    }

    public void openArtsPage() {
        navigationList.get(6).click();
    }

    public void openTravelPage() {
        navigationList.get(7).click();
    }

    public void openEarthPage() {
        navigationList.get(8).click();
    }

    public void openVideoPage() {
        navigationList.get(9).click();
    }

    public void openLivePage() {
        navigationList.get(10).click();
    }
}
