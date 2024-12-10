package com.zebrunner.carina.bbc.pages.mobile;

import com.zebrunner.carina.bbc.pages.ArticlePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ArticlePageBase.class)
public class ArticlePageMobile extends ArticlePageBase {
    public ArticlePageMobile(WebDriver driver) {
        super(driver);
    }
}
