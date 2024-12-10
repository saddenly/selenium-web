package com.zebrunner.carina.bbcTests;

import com.zebrunner.carina.bbc.components.*;
import com.zebrunner.carina.bbc.enums.FooterNavigationBarItem;
import com.zebrunner.carina.bbc.enums.Language;
import com.zebrunner.carina.bbc.enums.NavigationBarItem;
import com.zebrunner.carina.bbc.pages.*;
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
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public abstract class BBCTests extends AbstractTest {

    protected HomePageBase homePage;
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

    @Test//mobile+desktop
    public void testOpenPage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Error opening home page");
    }

    @Test//mobile+desktop
    public void testFooterNavigationBar() {
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

    @Ignore
    @Test//desktop
    public abstract void testNavigationBar();

    @Test
    public void executeTestNavigationBar() {
        testNavigationBar();
    }

    @Test(dataProvider = "searchQueries")//mobile+desktop
    public void testOpenSearchPage(String id, String query) {
        Header header = homePage.getHeader();
        header.openSearchMenu();
        header.enterSearchQuery(query);
        SearchPageBase searchPage = header.clickSearchButton();

        assertTrue("URL does not contain search", searchPage.getCurrentUrl().contains("search"));
        assertTrue("Given query was not found", searchPage.getArticleHeadlines().stream().anyMatch(a -> a.contains(query)));
    }

    @Test(dataProvider = "invalidSearchQueries")//mobile+desktop
    public void testInvalidSearchQueryReturnsNothing(String id, String query) {
        Header header = homePage.getHeader();
        header.openSearchMenu();
        header.enterSearchQuery(query);

        SearchPageBase searchPage = header.clickSearchButton();
        assertTrue("URL does not contain search", searchPage.getCurrentUrl().contains("search"));
        assertFalse("Given query was found", searchPage.getArticleHeadlines().stream().anyMatch(a -> a.contains(query)));
    }

    @Test//mobile+desktop
    public void testArticlePage() {
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

    @Ignore
    @Test(dataProvider = "loginCredentials")//desktop
    public abstract void testLogin(String id, String username, String password);

    @Test(dataProvider = "loginCredentials")
    public void executeTestLogin(String id, String username, String password) {
        testLogin(id, username, password);
    }

    @Test//desktop
    public abstract void testNewsletterSubscription();

    @Test
    public void executeTestNewsletterSubscription() {
        testNewsletterSubscription();
    }

    @Test(dataProvider = "loginCredentials")//desktop
    public abstract void testSaveFunctionality(String id, String login, String password);

    @Test(dataProvider = "loginCredentials")
    public void executeTestSaveFunctionality(String id, String login, String password) {
        testSaveFunctionality(id, login, password);
    }
}
