package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CulturePageBase.class)
public class CulturePage extends CulturePageBase {
    public CulturePage(WebDriver driver) {
        super(driver);
    }
}
