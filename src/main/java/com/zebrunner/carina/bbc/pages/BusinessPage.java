package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BusinessPageBase.class)
public class BusinessPage extends BusinessPageBase {
    public BusinessPage(WebDriver driver) {
        super(driver);
    }
}
