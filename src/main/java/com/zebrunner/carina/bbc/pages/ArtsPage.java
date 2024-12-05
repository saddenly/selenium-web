package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ArtsPageBase.class)
public class ArtsPage extends ArtsPageBase {
    public ArtsPage(WebDriver driver) {
        super(driver);
    }
}
