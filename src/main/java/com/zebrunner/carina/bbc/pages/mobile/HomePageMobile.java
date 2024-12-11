package com.zebrunner.carina.bbc.pages.mobile;

import com.zebrunner.carina.bbc.components.Navigation;
import com.zebrunner.carina.bbc.components.mobile.HeaderMobile;
import com.zebrunner.carina.bbc.pages.HomePageBase;
import com.zebrunner.carina.bbc.pages.LoginPageBase;
import com.zebrunner.carina.bbc.pages.SavedItemsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePageMobile extends HomePageBase {
    @FindBy(xpath = "//header")
    private HeaderMobile header;

    public HomePageMobile(WebDriver driver) {
        super(driver);
    }

    public HeaderMobile getHeader() {
        return header;
    }

    @Override
    public Navigation getNavigation() {
        return null;
    }

    @Override
    public SavedItemsPageBase openSavedItemsPage() {
        return header.openBurgerMenu().openSavedItemsPage();
    }

    @Override
    public LoginPageBase openLoginPage() {
        return header.openBurgerMenu().openLoginPage();
    }

    //TODO: BURGER MENU RETURN SAVED BUTTON VISIBLE
    @Override
    public boolean isLoggedIn() {
        return header.openBurgerMenu().getSavedButton().isDisplayed();
    }
}
