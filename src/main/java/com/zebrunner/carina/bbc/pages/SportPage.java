package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SportPageBase.class)
public class SportPage extends SportPageBase {
    public SportPage(WebDriver driver) {
        super(driver);
    }
}
