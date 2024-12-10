package com.zebrunner.carina.bbc.pages.mobile;

import com.zebrunner.carina.bbc.pages.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class SearchPageMobile extends SearchPageBase {
    public SearchPageMobile(WebDriver driver) {
        super(driver);
    }
}
