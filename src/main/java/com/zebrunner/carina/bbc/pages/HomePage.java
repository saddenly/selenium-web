package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.bbc.components.Navigation;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(xpath = "//nav[@data-testid='level1-navigation-container']/section/nav")
    private Navigation navigation;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Navigation getNavigation() {
        return navigation;
    }
}
