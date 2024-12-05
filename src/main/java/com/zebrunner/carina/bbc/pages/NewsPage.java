package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase {
    @FindBy(xpath = "//div[@data-testid='news-logo-container']/*/*[1]")
    private ExtendedWebElement headline;

    public NewsPage(WebDriver driver) {
        super(driver);
    }
}
