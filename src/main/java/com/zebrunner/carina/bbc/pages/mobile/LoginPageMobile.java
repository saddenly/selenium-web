package com.zebrunner.carina.bbc.pages.mobile;

import com.zebrunner.carina.bbc.pages.HomePageBase;
import com.zebrunner.carina.bbc.pages.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPageMobile extends LoginPageBase {

    public LoginPageMobile(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePageBase login(String username, String password) {
        this.username.type(username);
        loginButton.click();
        this.password.type(password);
        loginButton.click();
        WebElement logo = getDriver().findElement(By.xpath("//header//div[@id='global-navigation']/div/a[@href='https://www.bbc.com']"));
        logo.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}
