package com.zebrunner.carina.bbc;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//button[@aria-label='Search BBC']")
    private ExtendedWebElement buttonSearchForm;

    @FindBy(css = "input[data-testid='search-input-field']")
    private ExtendedWebElement inputSearchField;

    @FindBy(css = "button[data-testid='search-input-search-button']")
    private ExtendedWebElement buttonSearch;

    @FindBy(css = "#notice > div.message-component.message-row.unstack > div:nth-child(2)")
    private ExtendedWebElement agreeToCookiesButton;

    @FindBy(css = "#bbccookies-continue-button")
    private ExtendedWebElement agreeToCookiesSpan;

    @FindBy(css = "#__next > div > nav > section > nav > ul > li")
    private List<ExtendedWebElement> navigationItems;

    @FindBy(css = "#main-content > article > section:nth-child(1) > div > div.sc-e70150c3-0.fbvxoY > div.sc-93223220-0.bOZIBp > div.sc-93223220-0.sc-e70150c3-1.gPmTJa.fNRFwC > div:nth-child(1)")
    private ExtendedWebElement firstArticle;

    @FindBy(css = "#__next > div > footer > section.sc-b310c64c-0.cUeFDY > div > button")
    private ExtendedWebElement otherLanguagesButton;

    @FindBy(css = "#__next > div > footer > section.sc-b310c64c-0.cUeFDY > div > div > div > div:nth-child(28) > a")
    private ExtendedWebElement russianLanguageButton;

    @FindBy(css = "#__next > div > header > div > div.sc-28ab61fc-12.kABLhb > div > div:nth-child(2) > a > button")
    private ExtendedWebElement loginButton;

    @FindBy(css = "#__next > div > header > div > div.sc-28ab61fc-12.kABLhb > div > div > button")
    private ExtendedWebElement profileButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[6]/div/div[16]/a/button")
    private ExtendedWebElement newsletterButton;

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
    
    public void openSearchForm() {
        buttonSearchForm.click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    public void enterSearchQuery(String query) {
        inputSearchField.type(query);
    }

    public SearchPageBase clickSearch() {
        buttonSearch.click();
        return initPage(driver, SearchPageBase.class);
    }

    public List<ExtendedWebElement> getNavigationItems() {
        return navigationItems;
    }

    public VideoPageBase openVideoPage() {
        navigationItems.get(9).click();
        return initPage(driver, VideoPageBase.class);
    }

    public ArticlePageBase openFirstArticle() {
        firstArticle.click();
        return initPage(driver, ArticlePageBase.class);
    }

    public void changeLanguageToRussian() {
        otherLanguagesButton.click();
        russianLanguageButton.click();
    }

    public LoginPageBase openLoginPage() {
        loginButton.click();
        return initPage(driver, LoginPageBase.class);
    }

    public boolean isProfileButtonVisible() {
        return profileButton.isDisplayed();
    }

    public NewsletterPageBase openNewsletterPage() {
        newsletterButton.click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return initPage(driver, NewsletterPageBase.class);
    }
}
