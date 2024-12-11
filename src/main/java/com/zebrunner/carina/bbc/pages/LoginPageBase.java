package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class LoginPageBase extends AbstractPage {
    @FindBy(xpath = "//input[@data-testid='input']")
    protected ExtendedWebElement username;

    @FindBy(xpath = "//input[@data-testid='input']")
    protected ExtendedWebElement password;

    @FindBy(xpath = "//button[@id='submit-button']")
    protected ExtendedWebElement loginButton;

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HomePageBase login(String username, String password);
}
