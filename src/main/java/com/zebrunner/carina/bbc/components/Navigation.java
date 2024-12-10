package com.zebrunner.carina.bbc.components;

import com.zebrunner.carina.bbc.enums.NavigationBarItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Navigation extends AbstractUIObject {
    @FindBy(xpath = "./ul/li/div/a[text()='%s']")
    private ExtendedWebElement item;

    public Navigation(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getItem(NavigationBarItem navItem) {
        return item.format(navItem.getName());
    }
}
