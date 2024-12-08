package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.bbc.components.NewsletterCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class NewsletterPageBase extends AbstractPage {
    public NewsletterPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ExtendedWebElement getConfirmationMessage();

    public abstract NewsletterCard getNewsletterCard(int index);

    public abstract ExtendedWebElement getSubscribeButton();
}
