package com.zebrunner.carina.bbc;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SavedItemsPageBase.class)
public class SavedItemsPage extends SavedItemsPageBase {
    @FindBy(css = "#main-content > div.sc-794f4ec1-0.sc-9437d18f-1.FLXyL.hvXzGq > div > div > div > div > a > div > div")
    private ExtendedWebElement savedItem;

    public SavedItemsPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getSavedItem() {
        return savedItem;
    }
}
