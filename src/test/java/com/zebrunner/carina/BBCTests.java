package com.zebrunner.carina;

import com.zebrunner.carina.bbc.components.Header;
import com.zebrunner.carina.bbc.pages.*;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class BBCTests extends AbstractTest {

    private HomePageBase homePage;

    @BeforeTest
    public void setup() {
        homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.agreeToCookies();
    }

    @Test
    public void testOpenPage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Error opening home page");
    }

    @Test
    public void testNavigationBar() {
        List<ExtendedWebElement> navigationItems = homePage.getNavigation().getNavigationList();

        for (int i = 1; i < navigationItems.size(); i++) {
            String navigationItemText = navigationItems.get(i).getText();

            navigationItems.get(i).click();

            String currentUrl = getDriver().getCurrentUrl();
            String expectedName;

            if (navigationItemText.equals("Earth")) {
                expectedName = "future-planet";
                assertTrue("URL does not contain expected text: " + expectedName, currentUrl.contains(expectedName));
            } else {
                expectedName = navigationItemText.toLowerCase();
                assertTrue("URL does not contain expected text: " + expectedName, currentUrl.contains(expectedName));
            }

            WebElement mainContent = getDriver().findElement(By.id("main-content"));
            assertTrue("Main content is not visible", mainContent.isDisplayed());

            getDriver().navigate().back();

            navigationItems = homePage.getNavigation().getNavigationList();
        }
    }

    @Test
    public void testOpenSearchPage() {
        Header header = homePage.getHeader();
        header.openSearchMenu();
        header.enterSearchQuery("some");

        SearchPageBase searchPage = header.clickSearchButton();
        assertTrue("URL does not contain search", searchPage.getCurrentUrl().contains("search"));
        assertTrue("Error opening search page", searchPage.isPageOpened());
    }

    @Test
    public void testInvalidSearchQueryReturnsNothing() {
        Header header = homePage.getHeader();
        header.openSearchMenu();
        header.enterSearchQuery("gsfdhgjhgjkhghgnfgbv");

        SearchPageBase searchPage = header.clickSearchButton();
        assertTrue("URL does not contain search", searchPage.getCurrentUrl().contains("search"));
        System.out.println(searchPage.isPageOpened());
        assertFalse("There is unexpected result", searchPage.isPageOpened());
    }

    @Test
    public void testArticlePage() {
        ArticlePageBase articlePage = homePage.openFirstArticle();
        assertTrue("URL does not contain 'articles'", getDriver().getCurrentUrl().contains("news"));

        assertFalse("Article header is empty", articlePage.getHeaderText().isEmpty());
        assertFalse("Article publication time is empty", articlePage.getPublicationTime().isEmpty());
    }

    @Test
    public void testLanguageChange() {
        homePage.changeLanguageToRussian();
        assertTrue("Error changing language to russian", getDriver().getCurrentUrl().contains("russian"));
    }

    @Test
    public void testLogin() {
        LoginPageBase loginPage = homePage.getHeader().openLoginPage();
        assertTrue("URL does not contain 'auth'", loginPage.getCurrentUrl().contains("auth"));

        homePage = loginPage.login("rustemandasov6@gmail.com", "Bbc_8584");
        assertTrue("Profile button is not visible", homePage.getHeader().isProfileButtonVisible());
    }

    @Test
    public void testNewsletterSubscription() {
        LoginPageBase loginPage = homePage.getHeader().openLoginPage();
        homePage = loginPage.login("rustemandasov6@gmail.com", "Bbc_8584");

        NewsletterPageBase newsletterPage = homePage.getHeader().openBurgerMenu().openNewsletterPage();
        newsletterPage.subscribeToNewsletter();
        assertTrue("Confirmation message was not displayed", newsletterPage.getConfirmationMessage().isDisplayed());
        //does not work
    }

    @Test
    public void testSaveFunctionality() {
        LoginPageBase loginPage = homePage.getHeader().openLoginPage();
        homePage = loginPage.login("rustemandasov6@gmail.com", "Bbc_8584");
        ArticlePageBase articlePage = homePage.openFirstArticle();
        articlePage.saveArticle();
        SavedItemsPageBase savedItemsPage = articlePage.openSavedPage();
        assertTrue("Saved item is not displayed", savedItemsPage.getSavedItem().isDisplayed());
    }

}
