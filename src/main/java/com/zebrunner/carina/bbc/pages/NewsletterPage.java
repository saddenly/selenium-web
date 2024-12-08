package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.bbc.components.NewsletterCard;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = NewsletterPageBase.class)
public class NewsletterPage extends NewsletterPageBase {
    @FindBy(xpath = "//div[@class='NewsletterOptionPanel_NewsletterOptionPanelWrapper__Mhsul']")
    private List<NewsletterCard> newsletterCards;

    @FindBy(xpath = "//button[text()='Subscribe']")
    private ExtendedWebElement subscribeButton;

    @FindBy(xpath = "//p[@data-testid='banner-confirmation-text']")
    private ExtendedWebElement confirmationMessage;

    public NewsletterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewsletterCard getNewsletterCard(int index) {
        return newsletterCards.get(index);
    }

    @Override
    public ExtendedWebElement getSubscribeButton() {
        return subscribeButton;
    }

    @Override
    public ExtendedWebElement getConfirmationMessage() {
        return confirmationMessage;
    }
}
