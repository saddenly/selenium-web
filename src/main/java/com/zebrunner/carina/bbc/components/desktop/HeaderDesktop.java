package com.zebrunner.carina.bbc.components.desktop;

import com.zebrunner.carina.bbc.components.Header;
import com.zebrunner.carina.bbc.pages.LoginPageBase;
import com.zebrunner.carina.bbc.pages.SavedItemsPageBase;
import com.zebrunner.carina.bbc.pages.SearchPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderDesktop extends Header {
    @FindBy(xpath = ".//button[@aria-label='Sign In']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = ".//button[@aria-label='Register']")
    private ExtendedWebElement registerButton;

    @FindBy(xpath = ".//button[text()='Your Account']")
    private ExtendedWebElement profileButton;

    @FindBy(xpath = ".//a[@href='https://www.bbc.com/saved']")
    private ExtendedWebElement savedButton;


    public HeaderDesktop(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginPageBase openLoginPage() {
        signInButton.click();
        return initPage(driver, LoginPageBase.class);
    }

    public void openProfileDropdown() {
        profileButton.click();
    }

    public SavedItemsPageBase openSavedArticlesPage() {
        savedButton.click();
        return initPage(getDriver(), SavedItemsPageBase.class);
    }

    public boolean isProfileButtonVisible() {
        return profileButton.isDisplayed();
    }
}
