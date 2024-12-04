package com.zebrunner.carina.bbc;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = NewsletterPageBase.class)
public class NewsletterPage extends NewsletterPageBase {
    @FindBy(xpath = "//input[@data-testid='switch-toggle-checkbox']/..")
    private ExtendedWebElement newsletterSwitch;

    @FindBy(xpath = "//button[text()='Subscribe']")
    private ExtendedWebElement subscribeButton;

    @FindBy(xpath = "//p[@data-testid='banner-confirmation-text']")
    private ExtendedWebElement confirmationMessage;

    public NewsletterPage(WebDriver driver) {
        super(driver);
    }

    public void subscribeToNewsletter() {
        newsletterSwitch.click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        subscribeButton.click();
    }

    @Override
    public ExtendedWebElement getConfirmationMessage() {
        return confirmationMessage;
    }
}
