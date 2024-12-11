package com.zebrunner.carina.bbc.components.mobile;

import com.zebrunner.carina.bbc.components.BurgerMenu;
import com.zebrunner.carina.bbc.components.Header;
import com.zebrunner.carina.bbc.pages.LoginPageBase;
import com.zebrunner.carina.bbc.pages.SavedItemsPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMobile extends Header {
    @FindBy(xpath = "//div[@data-testid='drawer-background']/div")
    private BurgerMenuMobile burgerMenuContainer;

    public HeaderMobile(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public BurgerMenuMobile openBurgerMenu() {
        burgerButton.click();
        return burgerMenuContainer;
    }
}
