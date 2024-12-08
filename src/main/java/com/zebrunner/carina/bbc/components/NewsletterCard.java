package com.zebrunner.carina.bbc.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NewsletterCard extends AbstractUIObject {
    @FindBy(xpath = ".//input[@data-testid='switch-toggle-checkbox']/../label")
    private ExtendedWebElement newsletterSwitch;

    public NewsletterCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getNewsletterSwitch() {
        return newsletterSwitch;
    }
}
