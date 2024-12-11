package com.zebrunner.carina.bbc.pages.mobile;

import com.zebrunner.carina.bbc.pages.SavedItemsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SavedItemsPageBase.class)
public class SavedItemsPageMobile extends SavedItemsPageBase {
    public SavedItemsPageMobile(WebDriver driver) {
        super(driver);
    }
}
