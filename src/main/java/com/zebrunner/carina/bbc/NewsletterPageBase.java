package com.zebrunner.carina.bbc;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class NewsletterPageBase extends AbstractPage {
    public NewsletterPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void subscribeToNewsletter();

    public abstract ExtendedWebElement getConfirmationMessage();
}
