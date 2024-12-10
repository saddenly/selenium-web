package com.zebrunner.carina;

import com.zebrunner.carina.bbc.components.*;
import com.zebrunner.carina.bbc.enums.Language;
import com.zebrunner.carina.bbc.pages.*;
import com.zebrunner.carina.bbc.enums.NavigationBarItem;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class BBCTests extends AbstractTest {

    private HomePageBase homePage;
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @BeforeTest
    public void setup() {
        homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.agreeToCookies();
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
        return new Object[][] {
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

    @Test
    public void testOpenPage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Error opening home page");
    }

    @Test
    public void testNavigationBar() {
        Navigation navigation = homePage.getNavigation();
        List<ExtendedWebElement> navigationItems = navigation.getNavigationList();

        for (int i = 1; i < navigationItems.size(); i++) {
            String expectedUrl = NavigationBarItem.values()[i].getPath();

            navigation.getItem(i + 1).click();

            String currentUrl = getDriver().getCurrentUrl();

            assertTrue("URL does not contain expected text: " + expectedUrl, currentUrl.contains(expectedUrl));

            WebElement mainContent = getDriver().findElement(By.id("main-content"));
            assertTrue("Main content is not visible", mainContent.isDisplayed());

            getDriver().navigate().back();

            navigationItems = homePage.getNavigation().getNavigationList();
        }
    }

    @Test(dataProvider = "searchQueries")
    public void testOpenSearchPage(String id, String query) {
        Header header = homePage.getHeader();
        header.openSearchMenu();
        header.enterSearchQuery(query);
        SearchPageBase searchPage = header.clickSearchButton();

        assertTrue("URL does not contain search", searchPage.getCurrentUrl().contains("search"));
        assertTrue("Given query was not found", searchPage.getArticleHeadlines().stream().anyMatch(a -> a.contains(query)));
    }

    @Test(dataProvider = "invalidSearchQueries")
    public void testInvalidSearchQueryReturnsNothing(String id, String query) {
        Header header = homePage.getHeader();
        header.openSearchMenu();
        header.enterSearchQuery(query);

        SearchPageBase searchPage = header.clickSearchButton();
        assertTrue("URL does not contain search", searchPage.getCurrentUrl().contains("search"));
        assertFalse("Given query was found", searchPage.getArticleHeadlines().stream().anyMatch(a -> a.contains(query)));
    }

    @Test
    public void testArticlePage() {
        EdinburghArticleCard articleCard = homePage.getEdinburghArticleCards().get(2);
        String headline = articleCard.getCardHeadline().getText();
        articleCard.click();
        ArticlePageBase articlePage = articleCard.openArticlePage();
        assertTrue("URL does not contain 'article'", getDriver().getCurrentUrl().contains("article"));
        assertTrue("Headlines are different", articlePage.getHeaderText().contains(headline));
        assertFalse("Article publication time is empty", articlePage.getPublicationTime().isEmpty());
    }

    @Test(dataProvider = "languages")
    public void testLanguageChange(String id, Language language) {

        ExtendedWebElement otherLanguagesButton = homePage.getOtherLanguagesButton();

        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(otherLanguagesButton));
        if (!homePage.getLanguageButton().isElementPresent()) otherLanguagesButton.click();
        pause(2);
        homePage.changeLanguage(language);

        getDriver().navigate().back();
    }

    @Test(dataProvider = "loginCredentials")
    public void testLogin(String id, String username, String password) {
        LoginPageBase loginPage = homePage.getHeader().openLoginPage();
        assertTrue("URL does not contain 'auth'", loginPage.getCurrentUrl().contains("auth"));

        homePage = loginPage.login(username, password);
        assertTrue("Profile button is not visible", homePage.getHeader().isProfileButtonVisible());
    }

    @Test
    public void testNewsletterSubscription() {
        LoginPageBase loginPage = homePage.getHeader().openLoginPage();
        homePage = loginPage.login(R.TESTDATA.get("user"), R.TESTDATA.get("password"));

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

    @Test(dataProvider = "loginCredentials")
    public void testSaveFunctionality(String id, String login, String password) {
        LoginPageBase loginPage = homePage.getHeader().openLoginPage();
        homePage = loginPage.login(login, password);
        EdinburghArticleCard articleCard = homePage.getEdinburghArticleCards().get(0);
        articleCard.click();
        ArticlePageBase articlePage = articleCard.openArticlePage();
        articlePage.saveArticle();
        String headline = articlePage.getHeaderText();
        articlePage.getHeader().openProfileDropdown();
        SavedItemsPageBase savedItemsPage = articlePage.getHeader().openSavedArticlesPage();
        pause(2);
        assertTrue("Saved article is not present", savedItemsPage.getSavedItemsHeadlines().stream().anyMatch(a -> a.getText().contains(headline)));
        assertTrue("Saved item is not displayed", savedItemsPage.getSavedItems().stream().allMatch(ExtendedWebElement::isDisplayed));
    }

}
