package com.zebrunner.carina.bbc.components;

import com.zebrunner.carina.bbc.enums.FooterNavigationBarItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterNavigation extends AbstractUIObject {
    @FindBy(xpath = "//nav[@aria-label='Footer navigation']//a[text()='%s']")
    private ExtendedWebElement navigationItem;

    public FooterNavigation(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getNavigationItem(FooterNavigationBarItem item) {
        return navigationItem.format(item);
    }
}
