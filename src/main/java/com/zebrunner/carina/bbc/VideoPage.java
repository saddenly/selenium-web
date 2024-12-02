package com.zebrunner.carina.bbc;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = VideoPageBase.class)
public class VideoPage extends VideoPageBase {
    @FindBy(css = "#main-content > article > section:nth-child(2) > div > div > div.sc-b6dc157-0.fcFCMT > div.sc-b6dc157-3.lnmnTw > div > div > button")
    public ExtendedWebElement playButton;

    @FindBy(css = "#toucan-bbcMediaPlayer0")
    public ExtendedWebElement videoPlayer;

    public VideoPage(WebDriver driver) {
        super(driver);
    }

    public void playVideo() {
        playButton.click();
    }
}
