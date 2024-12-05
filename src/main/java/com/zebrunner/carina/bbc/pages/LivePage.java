package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LivePageBase.class)
public class LivePage extends LivePageBase {
    public LivePage(WebDriver driver) {
        super(driver);
    }
}
