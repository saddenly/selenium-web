package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.bbc.components.EdinburghArticleCard;
import com.zebrunner.carina.bbc.components.Footer;
import com.zebrunner.carina.bbc.components.Header;
import com.zebrunner.carina.bbc.components.Navigation;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public abstract class HomePageBase extends LoggedInPage {
    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(xpath = "//button[@aria-label='I agree']")
    private ExtendedWebElement agreeToCookiesButton;

    @FindBy(xpath = "//span[text()='Yes, I agree']")
    private ExtendedWebElement agreeToCookiesSpan;

    @FindBy(xpath = "//div[@data-testid='edinburgh-article']")
    private List<EdinburghArticleCard> edinburghArticleCards;

    @FindBy(xpath = "//footer")
    private Footer footer;

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public void agreeToCookies() {
        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1));
        getDriver().switchTo().frame("sp_message_iframe_1192447");
        wait.until(ExpectedConditions.elementToBeClickable(agreeToCookiesButton));

        agreeToCookiesButton.click();
        getDriver().switchTo().parentFrame();
        agreeToCookiesSpan.click();
    }

    public Header getHeader(){
        return header;
    }

    public List<EdinburghArticleCard> getEdinburghArticleCards() {
        return edinburghArticleCards;
    }

    public Footer getFooter() {
        return footer;
    }

    public abstract Navigation getNavigation();

    public abstract LoginPageBase openLoginPage();

    public abstract boolean isLoggedIn();
}
