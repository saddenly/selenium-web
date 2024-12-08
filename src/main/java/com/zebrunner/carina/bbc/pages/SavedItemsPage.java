package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SavedItemsPageBase.class)
public class SavedItemsPage extends SavedItemsPageBase {
    @FindBy(xpath = "//div[@data-testid='newcastle-article']")
    private List<ExtendedWebElement> savedItems;

    @FindBy(xpath = "//h2[@data-testid='card-headline']")
    private List<ExtendedWebElement> savedItemsHeadlines;

    public SavedItemsPage(WebDriver driver) {
        super(driver);
    }

    public List<ExtendedWebElement> getSavedItems() {
        return savedItems;
    }

    public List<ExtendedWebElement> getSavedItemsHeadlines() {
        return savedItemsHeadlines;
    }
}
