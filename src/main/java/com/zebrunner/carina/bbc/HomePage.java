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

    @FindBy(xpath = "//input[@data-testid='search-input-field']")
    private ExtendedWebElement inputSearchField;

    @FindBy(xpath = "//button[@data-testid='search-input-search-button']")
    private ExtendedWebElement buttonSearch;

    @FindBy(xpath = "//button[@aria-label='I agree']")
    private ExtendedWebElement agreeToCookiesButton;

    @FindBy(xpath = "//span[text()='Yes, I agree']")
    private ExtendedWebElement agreeToCookiesSpan;

    @FindBy(xpath = "//nav[@data-testid='level1-navigation-container']/section/nav/ul/li")
    private List<ExtendedWebElement> navigationItems;

    @FindBy(css = "#main-content > article > section:nth-child(1) > div > div.sc-e70150c3-0.fbvxoY > div.sc-93223220-0.bOZIBp > div.sc-93223220-0.sc-e70150c3-1.gPmTJa.fNRFwC > div:nth-child(1)")
    private ExtendedWebElement firstArticle;

    @FindBy(xpath = "//footer//button[text()]")
    private ExtendedWebElement otherLanguagesButton;

    @FindBy(xpath = "//a[text()='Russian НА РУССКОМ']")
    private ExtendedWebElement russianLanguageButton;

    @FindBy(xpath = "//button[@aria-label='Sign In']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//button[text()='Your Account']")
    private ExtendedWebElement profileButton;

    @FindBy(xpath = "//button[@data-testid='level1NavButton-https://www.bbc.com/newsletters']")
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
