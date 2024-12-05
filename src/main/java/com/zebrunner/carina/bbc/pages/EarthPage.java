package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = EarthPageBase.class)
public class EarthPage extends EarthPageBase {
    public EarthPage(WebDriver driver) {
        super(driver);
    }
}
