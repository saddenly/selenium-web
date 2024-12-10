package com.zebrunner.carina.bbc.components.mobile;

import com.zebrunner.carina.bbc.components.BurgerMenu;
import com.zebrunner.carina.bbc.pages.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BurgerMenuMobile extends BurgerMenu {
    @FindBy(xpath = "//a[text()='Sign In']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//a[text()='Register']")
    private ExtendedWebElement registerButton;

    public BurgerMenuMobile(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginPageBase openLoginPage() {
        return initPage(getDriver(), LoginPageBase.class);
    }

    public ExtendedWebElement getSignInButton() {
        return signInButton;
    }

    public ExtendedWebElement getRegisterButton() {
        return registerButton;
    }
}
