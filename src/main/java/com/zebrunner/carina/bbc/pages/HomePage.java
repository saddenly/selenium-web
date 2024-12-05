package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.bbc.components.Header;
import com.zebrunner.carina.bbc.components.Navigation;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

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

    @FindBy(xpath = "//a[contains(@href, 'news/articles')]")
    private List<ExtendedWebElement> newsArticles;

    @FindBy(xpath = "//a[contains(@href, 'news/articles')]//h2[@data-testid='card-headline']")
    private List<ExtendedWebElement> articlesHeadlines;

    @FindBy(xpath = "//footer//button[text()]")
    private ExtendedWebElement otherLanguagesButton;

    @FindBy(xpath = "//a[text()='Russian НА РУССКОМ']")
    private ExtendedWebElement russianLanguageButton;

    @FindBy(xpath = "//a[text()='Kyrgyz Кыргыз']")
    private ExtendedWebElement kyrgyzLanguageButton;

    @FindBy(xpath = "//a[text()='Ukrainian УКРАЇНСЬКA']")
    private ExtendedWebElement ukrainianLanguageButton;

    @FindBy(xpath = "//a[text()='French AFRIQUE']")
    private ExtendedWebElement frenchLanguageButton;

    @FindBy(xpath = "//a[text()='Serbian NA SRPSKOM']")
    private ExtendedWebElement serbianLanguageButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void agreeToCookies() {
        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1));
        getDriver().switchTo().frame("sp_message_iframe_1192447");
        wait.until(ExpectedConditions.visibilityOf(agreeToCookiesButton));

        agreeToCookiesButton.click();
        getDriver().switchTo().parentFrame();
        agreeToCookiesSpan.click();
    }

    public ArticlePageBase openArticle(int index) {
        newsArticles.get(index).click();
        return initPage(getDriver(), ArticlePageBase.class);
    }

    @Override
    public String getArticleHeadline(int index) {
        return articlesHeadlines.get(index).getText();
    }

    public void changeLanguageToRussian() {
        otherLanguagesButton.click();
        russianLanguageButton.click();
    }

    public void changeLanguageToKyrgyz() {
        otherLanguagesButton.click();
        kyrgyzLanguageButton.click();
    }

    public void changeLanguageToUkrainian() {
        otherLanguagesButton.click();
        ukrainianLanguageButton.click();
    }

    public void changeLanguageToFrench() {
        otherLanguagesButton.click();
        frenchLanguageButton.click();
    }

    public void changeLanguageToSerbian() {
        otherLanguagesButton.click();
        serbianLanguageButton.click();
    }

    @Override
    public Header getHeader() {
        return header;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    @Override
    public ExtendedWebElement getOtherLanguagesButton() {
        return otherLanguagesButton;
    }
}
