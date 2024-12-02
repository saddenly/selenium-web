package com.zebrunner.carina.bbc;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class VideoPageBase extends AbstractPage {
    public VideoPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void playVideo();

    //public abstract void pauseVideo();
}
