package com.zebrunner.carina.bbcTests;

import com.zebrunner.carina.bbc.components.*;
import com.zebrunner.carina.bbc.enums.*;
import com.zebrunner.carina.bbc.pages.*;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class BBCTests extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public HomePageBase setup() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.agreeToCookies();
        return homePage;
    }

    @DataProvider(name = "searchQueries")
    public Object[][] getSearchQueries() {
        return new Object[][]{
                {"id=1", "Barnier downfall threatens to set a pattern for what lies ahead"},
                {"id=2", "French government collapses in no-confidence vote"},
                {"id=3", "Behind the scenes of the Baltimore bridge collapse"}
        };
    }

    @DataProvider(name = "invalidSearchQueries")
    public Object[][] getInvalidSearchQueries() {
        return new Object[][]{
                {"id=1", "22222222222222222222"},
                {"id=2", "daskofgnjmblvxc"},
                {"id=3", ".............^^$@%@^$%@"}
        };
    }

    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginCredentials() {
        return new Object[][]{
                {"id=1", R.TESTDATA.get("user"), R.TESTDATA.get("password")}
        };
    }

    @DataProvider(name = "languages")
    public Object[][] getLanguages() {
        return new Object[][]{
                {"id=1", Language.RUSSIAN},
                {"id=2", Language.KYRGYZ},
                {"id=3", Language.UKRAINIAN},
                {"id=4", Language.FRENCH},
                {"id=5", Language.SERBIAN},
        };
    }

    @DataProvider(name = "footerSocials")
    public Object[][] getFooterSocials() {
        return new Object[][]{
                {"id=1", FooterSocial.X, SocialSection.X_NEWS},
                {"id=2", FooterSocial.X, SocialSection.X_EARTH},
                {"id=3", FooterSocial.FACEBOOK, SocialSection.FACEBOOK_CULTURE},
                {"id=4", FooterSocial.INSTAGRAM, SocialSection.INSTAGRAM_BREAKING}
        };
    }

    @Test//mobile+desktop
    public void testOpenPage() {
        HomePageBase homePage = setup();
        Assert.assertTrue(homePage.isPageOpened(), "Error opening home page");
    }

    @Test//mobile+desktop
    public void testFooterNavigationBar() {
        HomePageBase homePage = setup();
        FooterNavigation navigation = homePage.getFooter().getFooterNavigation();

        for (FooterNavigationBarItem item : Arrays.stream(FooterNavigationBarItem.values()).skip(1).collect(Collectors.toList())) {
            String expectedUrl = item.getUrl();
            navigation.getNavigationItem(item).click();
            String currentUrl = getDriver().getCurrentUrl();
            assertTrue("URL does not contain expected text: " + expectedUrl, currentUrl.contains(expectedUrl));
            getDriver().navigate().back();
            navigation = homePage.getFooter().getFooterNavigation();
        }
    }

    @Test//desktop
    public void testNavigationBar() {
        HomePageBase homePage = setup();
        Navigation navigation = homePage.getNavigation();

        for (NavigationBarItem item : Arrays.stream(NavigationBarItem.values()).skip(1).collect(Collectors.toList())) {
            String expectedUrl = item.getPath();

            navigation.getItem(item).click();

            String currentUrl = getDriver().getCurrentUrl();

            assertTrue("URL does not contain expected text: " + expectedUrl, currentUrl.contains(expectedUrl));

            WebElement mainContent = getDriver().findElement(By.id("main-content"));
            assertTrue("Main content is not visible", mainContent.isDisplayed());

            getDriver().navigate().back();

            navigation = homePage.getNavigation();
        }
    }

    @Test(dataProvider = "searchQueries")//mobile+desktop
    public void testOpenSearchPage(String id, String query) {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.agreeToCookies();
        Header header = homePage.getHeader();
        BurgerMenu burgerMenu = header.openSearchMenu();
        burgerMenu.enterSearchQuery(query);
        SearchPageBase searchPage = burgerMenu.clickSearchButton();

        assertTrue("URL does not contain search", searchPage.getCurrentUrl().contains("search"));
        assertTrue("Given query was not found", searchPage.getArticleHeadlines().stream().anyMatch(a -> a.contains(query)));
    }

    @Test(dataProvider = "invalidSearchQueries")//mobile+desktop
    public void testInvalidSearchQueryReturnsNothing(String id, String query) {
        HomePageBase homePage = setup();
        BurgerMenu burgerMenu = homePage.getHeader().openSearchMenu();
        burgerMenu.enterSearchQuery(query);

        SearchPageBase searchPage = burgerMenu.clickSearchButton();
        assertTrue("URL does not contain search", searchPage.getCurrentUrl().contains("search"));
        assertFalse("Given query was found", searchPage.getArticleHeadlines().stream().anyMatch(a -> a.contains(query)));
    }

    @Test//mobile+desktop
    public void testArticlePage() {
        HomePageBase homePage = setup();
        EdinburghArticleCard articleCard = homePage.getEdinburghArticleCards().get(2);
        String headline = articleCard.getCardHeadline().getText();
        articleCard.click();
        ArticlePageBase articlePage = articleCard.openArticlePage();
        assertTrue("URL does not contain 'article'", getDriver().getCurrentUrl().contains("article"));
        assertTrue("Headlines are different", articlePage.getHeaderText().contains(headline));
        assertFalse("Article publication time is empty", articlePage.getPublicationTime().isEmpty());
    }

    @Test(dataProvider = "languages")//mobile+desktop
    public void testLanguageChange(String id, Language language) {
        HomePageBase homePage = setup();
        ExtendedWebElement otherLanguagesButton = homePage.getFooter().getOtherLanguagesButton();

        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(otherLanguagesButton));
        if (!homePage.getFooter().getLanguageButton(Language.RUSSIAN).isElementPresent()) otherLanguagesButton.click();
        pause(2);
        homePage.getFooter().changeLanguage(language);

        getDriver().navigate().back();
    }

    @Test(dataProvider = "loginCredentials")//desktop + mobile
    public void testLogin(String id, String username, String password) {
        HomePageBase homePage = setup();
        LoginPageBase loginPage = homePage.openLoginPage();
        assertTrue("URL does not contain 'auth'", loginPage.getCurrentUrl().contains("auth"));

        homePage = loginPage.login(username, password);
        assertTrue("Log in was not successful", homePage.isLoggedIn());
    }

    @Test(dataProvider = "loginCredentials")//desktop
    public void testNewsletterSubscription(String id, String username, String password) {
        HomePageBase homePage = setup();
        LoginPageBase loginPage = homePage.openLoginPage();
        homePage = loginPage.login(username, password);

        BurgerMenu burgerMenu = homePage.getHeader().openBurgerMenu();
        NewsletterPageBase newsletterPage = burgerMenu.openNewsletterPage();
        pause(2);
        NewsletterCard card = newsletterPage.getNewsletterCard(5);
        card.getNewsletterSwitch().click();
        pause(2);
        newsletterPage.getSubscribeButton().click();
        pause(5);

        assertTrue("Confirmation message was not displayed", newsletterPage.getConfirmationMessage().isDisplayed());
    }

    @Test(dataProvider = "loginCredentials")//desktop + mobile
    public void testSaveFunctionality(String id, String login, String password) {
        HomePageBase homePage = setup();
        LoginPageBase loginPage = homePage.openLoginPage();
        homePage = loginPage.login(login, password);
        EdinburghArticleCard articleCard = homePage.getEdinburghArticleCards().get(2);
        String headline = articleCard.getCardHeadline().getText();
        articleCard.click();
        ArticlePageBase articlePage = articleCard.openArticlePage();
        pause(2);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(articlePage.getSaveButton()));
        articlePage.saveArticle();
        pause(10);
        SavedItemsPageBase savedItemsPage = articlePage.openSavedItemsPage();
        wait.until(ExpectedConditions.elementToBeClickable(savedItemsPage.getSavedItems().get(0)));
        assertTrue("Saved article is not present", savedItemsPage.getSavedItemsHeadlines().stream().anyMatch(a -> headline.contains(a.getText())));
        assertTrue("Saved item is not displayed", savedItemsPage.getSavedItems().stream().allMatch(ExtendedWebElement::isDisplayed));
    }

    @Test(dataProvider = "footerSocials")// desktop + mobile
    public void testFooterSocials(String id, FooterSocial footerSocial, SocialSection socialSection) {
        HomePageBase homePage = setup();
        Footer footer = homePage.getFooter();
        footer.getSocialButton(footerSocial).click();
        footer.getSocialSectionButton(footerSocial, socialSection).click();
        getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[1].toString());
        assertTrue("The url is not correct", getDriver().getCurrentUrl().contains(socialSection.getUrl()));
    }
}
