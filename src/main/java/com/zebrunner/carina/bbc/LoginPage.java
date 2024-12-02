package com.zebrunner.carina.bbc;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase{
    @FindBy(css = "#user-identifier-input")
    private ExtendedWebElement username;

    @FindBy(css = "#password-input")
    private ExtendedWebElement password;

    @FindBy(css = "#submit-button")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePageBase login(String username, String password) {
        this.username.type(username);
        loginButton.click();
        this.password.type(password);
        loginButton.click();
        return initPage(driver, HomePageBase.class);
    }
}
