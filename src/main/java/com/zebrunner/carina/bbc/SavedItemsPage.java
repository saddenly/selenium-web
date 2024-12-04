package com.zebrunner.carina.bbc;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SavedItemsPageBase.class)
public class SavedItemsPage extends SavedItemsPageBase {
    @FindBy(xpath = "//div[@data-testid='newcastle-article']")
    private ExtendedWebElement savedItem;

    public SavedItemsPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getSavedItem() {
        return savedItem;
    }
}
