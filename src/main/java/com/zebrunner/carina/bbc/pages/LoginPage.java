package com.zebrunner.carina.bbc.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePageBase login(String username, String password) {
        this.username.type(username);
        loginButton.click();
        this.password.type(password);
        loginButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}
