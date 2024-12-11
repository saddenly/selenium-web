package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SavedItemsPageBase.class)
public class SavedItemsPage extends SavedItemsPageBase {
    public SavedItemsPage(WebDriver driver) {
        super(driver);
    }
}
