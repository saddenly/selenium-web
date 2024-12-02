package com.zebrunner.carina.bbc;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase{
    @FindBy(css = "#main-content > div.sc-32f23d22-0.heeShB > div > div.sc-32f23d22-2.iumrhG > div > div:nth-child(1)")
    private ExtendedWebElement articles;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return articles.isDisplayed();
    }
}
