package com.zebrunner.carina.bbc;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = NewsletterPageBase.class)
public class NewsletterPage extends NewsletterPageBase {
    @FindBy(xpath = "//*[@id=\"SixStepsToCalm\"]/div/div[3]/label")
    private ExtendedWebElement newsletterSwitch;

    @FindBy(xpath = "//*[@id=\"__next\"]/main/section[3]/div[2]/div/div/div[3]")
    private ExtendedWebElement subscribeButton;

    @FindBy(css = "#__next > main > section.BannerStyles_Banner__G7T_i.BannerStyles_ConfirmationBanner__tWR5d.BannerStyles_visible__YBcro > p.BannerStyles_BannerText__wfInP")
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
