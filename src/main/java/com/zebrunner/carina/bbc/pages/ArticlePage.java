package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ArticlePageBase.class)
public class ArticlePage extends ArticlePageBase {
    public ArticlePage(WebDriver driver) {
        super(driver);
    }
}
