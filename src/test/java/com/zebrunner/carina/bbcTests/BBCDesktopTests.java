package com.zebrunner.carina.bbcTests;

import com.zebrunner.carina.bbc.components.BurgerMenu;
import com.zebrunner.carina.bbc.components.EdinburghArticleCard;
import com.zebrunner.carina.bbc.components.Navigation;
import com.zebrunner.carina.bbc.components.NewsletterCard;
import com.zebrunner.carina.bbc.enums.NavigationBarItem;
import com.zebrunner.carina.bbc.pages.ArticlePageBase;
import com.zebrunner.carina.bbc.pages.LoginPageBase;
import com.zebrunner.carina.bbc.pages.NewsletterPageBase;
import com.zebrunner.carina.bbc.pages.SavedItemsPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertTrue;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BBCTests.class)
public class BBCDesktopTests extends BBCTests {

    @Override
    @Test//desktop
    public void testNavigationBar() {
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

    @Override
    @Test(dataProvider = "loginCredentials")//desktop
    public void testLogin(String id, String username, String password) {
        LoginPageBase loginPage = homePage.getHeader().openLoginPage();
        assertTrue("URL does not contain 'auth'", loginPage.getCurrentUrl().contains("auth"));

        homePage = loginPage.login(username, password);
        assertTrue("Profile button is not visible", homePage.getHeader().isProfileButtonVisible());
    }

    @Override
    @Test(dataProvider = "loginCredentials")//desktop
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

    @Override
    @Test(dataProvider = "loginCredentials")
    public void testNewsletterSubscription(String id, String username, String password) {
        LoginPageBase loginPage = homePage.getHeader().openLoginPage();
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
}
