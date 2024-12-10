package com.zebrunner.carina.bbc.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {
    @FindBy(xpath = ".//button[@aria-label='Open menu']")
    private ExtendedWebElement burgerButton;

    @FindBy(xpath = "//div[@data-testid='drawer-background']/div")
    private BurgerMenu burgerMenuContainer;

    @FindBy(xpath = ".//button[@aria-label='Search BBC']")
    private ExtendedWebElement searchMenuButton;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public BurgerMenu openBurgerMenu() {
        burgerButton.click();
        return burgerMenuContainer;
    }

    public BurgerMenu openSearchMenu() {
        searchMenuButton.click();
        return burgerMenuContainer;
    }
}
