package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.bbc.components.Header;
import com.zebrunner.carina.bbc.components.Navigation;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(xpath = "//nav[@data-testid='level1-navigation-container']/section/nav")
    private Navigation navigation;

    @FindBy(xpath = "//button[@aria-label='I agree']")
    private ExtendedWebElement agreeToCookiesButton;

    @FindBy(xpath = "//span[text()='Yes, I agree']")
    private ExtendedWebElement agreeToCookiesSpan;

    @FindBy(xpath = "//div[@data-testid='edinburgh-card'][2]")
    private ExtendedWebElement firstArticle;

    @FindBy(xpath = "//footer//button[text()]")
    private ExtendedWebElement otherLanguagesButton;

    @FindBy(xpath = "//a[text()='Russian НА РУССКОМ']")
    private ExtendedWebElement russianLanguageButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void agreeToCookies() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.switchTo().frame("sp_message_iframe_1192447");
        agreeToCookiesButton.click();
        driver.switchTo().parentFrame();
        agreeToCookiesSpan.click();
    }

    public ArticlePageBase openFirstArticle() {
        firstArticle.click();
        return initPage(driver, ArticlePageBase.class);
    }

    public void changeLanguageToRussian() {
        otherLanguagesButton.click();
        russianLanguageButton.click();
    }

    @Override
    public Header getHeader() {
        return header;
    }

    public Navigation getNavigation() {
        return navigation;
    }
}
