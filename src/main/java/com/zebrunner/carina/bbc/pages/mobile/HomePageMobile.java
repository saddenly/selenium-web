package com.zebrunner.carina.bbc.pages.mobile;

import com.zebrunner.carina.bbc.components.Navigation;
import com.zebrunner.carina.bbc.pages.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePageMobile extends HomePageBase {

    public HomePageMobile(WebDriver driver) {
        super(driver);
    }

    @Override
    public Navigation getNavigation() {
        return null;
    }
}
