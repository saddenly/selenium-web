package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = InnovationPageBase.class)
public class InnovationPage extends InnovationPageBase {
    public InnovationPage(WebDriver driver) {
        super(driver);
    }
}
