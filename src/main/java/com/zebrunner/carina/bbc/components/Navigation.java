package com.zebrunner.carina.bbc.components;

import com.zebrunner.carina.bbc.pages.*;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Navigation extends AbstractUIObject {
    @FindBy(xpath = "//nav[@data-testid='level1-navigation-container']/section/nav/ul/li[1]")
    private ExtendedWebElement home;

    @FindBy(xpath = "//nav[@data-testid='level1-navigation-container']/section/nav/ul/li[2]")
    private ExtendedWebElement news;

    @FindBy(xpath = "//nav[@data-testid='level1-navigation-container']/section/nav/ul/li[3]")
    private ExtendedWebElement sport;

    @FindBy(xpath = "//nav[@data-testid='level1-navigation-container']/section/nav/ul/li[4]")
    private ExtendedWebElement business;

    @FindBy(xpath = "//nav[@data-testid='level1-navigation-container']/section/nav/ul/li[5]")
    private ExtendedWebElement innovation;

    @FindBy(xpath = "//nav[@data-testid='level1-navigation-container']/section/nav/ul/li[6]")
    private ExtendedWebElement culture;

    @FindBy(xpath = "//nav[@data-testid='level1-navigation-container']/section/nav/ul/li[7]")
    private ExtendedWebElement arts;

    @FindBy(xpath = "//nav[@data-testid='level1-navigation-container']/section/nav/ul/li[8]")
    private ExtendedWebElement travel;

    @FindBy(xpath = "//nav[@data-testid='level1-navigation-container']/section/nav/ul/li[9]")
    private ExtendedWebElement earth;

    @FindBy(xpath = "//nav[@data-testid='level1-navigation-container']/section/nav/ul/li[10]")
    private ExtendedWebElement video;

    @FindBy(xpath = "//nav[@data-testid='level1-navigation-container']/section/nav/ul/li[11]")
    private ExtendedWebElement live;

    public Navigation(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ExtendedWebElement> getNavigationList() {
        return List.of(home, news, sport, business, innovation, culture, arts, travel, earth, video, live);
    }

    public HomePageBase openHomePage() {
        home.click();
        return initPage(driver, HomePageBase.class);
    }

    public NewsPageBase openNewsPage() {
        news.click();
        return initPage(getDriver(), NewsPageBase.class);
    }

    public SportPageBase openSportPage() {
        sport.click();
        return initPage(getDriver(), SportPageBase.class);
    }

    public BusinessPageBase openBusinessPage() {
        business.click();
        return initPage(getDriver(), BusinessPageBase.class);
    }

    public InnovationPageBase openInnovationPage() {
        innovation.click();
        return initPage(getDriver(), InnovationPageBase.class);
    }

    public CulturePageBase openCulturePage() {
        culture.click();
        return initPage(getDriver(), CulturePageBase.class);
    }

    public ArtsPageBase openArtsPage() {
        arts.click();
        return initPage(getDriver(), ArtsPageBase.class);
    }

    public TravelPageBase openTravelPage() {
        travel.click();
        return initPage(getDriver(), TravelPageBase.class);
    }

    public EarthPageBase openEarthPage() {
        earth.click();
        return initPage(getDriver(), EarthPageBase.class);
    }

    public VideoPageBase openVideoPage() {
        video.click();
        return initPage(getDriver(), VideoPageBase.class);
    }

    public LivePageBase openLivePage() {
        live.click();
        return initPage(getDriver(), LivePageBase.class);
    }
}
