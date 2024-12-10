package com.zebrunner.carina.bbc.components;

import com.zebrunner.carina.bbc.enums.Language;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Footer extends AbstractUIObject {
    @FindBy(xpath = ".//a[text()='%s']")
    private ExtendedWebElement languageButton;

    @FindBy(xpath = ".//button[text()]")
    private ExtendedWebElement otherLanguagesButton;

    @FindBy(xpath = ".//nav[@aria-label='Footer navigation']")
    private FooterNavigation footerNavigation;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void changeLanguage(Language language) {
        languageButton.format(language.getUrl()).click();
    }

    public ExtendedWebElement getOtherLanguagesButton() {
        return otherLanguagesButton;
    }

    public ExtendedWebElement getLanguageButton(Language language) {
        return languageButton.format(language.getUrl());
    }

    public FooterNavigation getFooterNavigation() {
        return footerNavigation;
    }
}
