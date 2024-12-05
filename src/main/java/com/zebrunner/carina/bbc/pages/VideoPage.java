package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = VideoPageBase.class)
public class VideoPage extends VideoPageBase {
    public VideoPage(WebDriver driver) {
        super(driver);
    }
}
