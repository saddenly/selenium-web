package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = TravelPageBase.class)
public class TravelPage extends TravelPageBase {
    public TravelPage(WebDriver driver) {
        super(driver);
    }
}
