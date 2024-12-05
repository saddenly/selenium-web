package com.zebrunner.carina.bbc.components;

import com.zebrunner.carina.bbc.pages.LoginPageBase;
import com.zebrunner.carina.bbc.pages.SavedItemsPageBase;
import com.zebrunner.carina.bbc.pages.SearchPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends AbstractUIObject {
    @FindBy(xpath = "//button[@aria-label='Open menu']")
    private ExtendedWebElement burgerButton;

    @FindBy(xpath = "//div[@data-testid='drawer-background']/div")
    private ExtendedWebElement burgerMenuContainer;

    @FindBy(xpath = "//button[@aria-label='Search BBC']")
    private ExtendedWebElement searchMenuButton;

    @FindBy(xpath = "//input[@data-testid='search-input-field']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//button[@data-testid='search-input-search-button']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//button[@aria-label='Register']")
    private ExtendedWebElement registerButton;

    @FindBy(xpath = "//button[@aria-label='Sign In']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//button[text()='Your Account']")
    private ExtendedWebElement profileButton;

    @FindBy(xpath = "//a[@href='https://www.bbc.com/saved']")
    private ExtendedWebElement savedButton;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public BurgerMenu openBurgerMenu() {
        burgerButton.click();
        return new BurgerMenu(getDriver(), burgerMenuContainer);
    }

    public void openSearchMenu() {
        searchMenuButton.click();
    }

    public LoginPageBase openLoginPage() {
        signInButton.click();
        return initPage(driver, LoginPageBase.class);
    }

    public void openProfileDropdown() {
        profileButton.click();
    }

    public SavedItemsPageBase openSavedArticlesPage() {
        openProfileDropdown();
        savedButton.click();
        return initPage(getDriver(), SavedItemsPageBase.class);
    }

    public void enterSearchQuery(String text) {
        searchInput.type(text);
    }

    public SearchPageBase clickSearchButton() {
        searchButton.click();
        return initPage(driver, SearchPageBase.class);
    }

    public boolean isProfileButtonVisible() {
        return profileButton.isDisplayed();
    }
}
