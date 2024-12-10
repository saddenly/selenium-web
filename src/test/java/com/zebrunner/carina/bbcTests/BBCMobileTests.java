package com.zebrunner.carina.bbcTests;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.testng.annotations.Test;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BBCTests.class)
public class BBCMobileTests extends BBCTests {
    @Override
    @Test
    public void testNavigationBar() {

    }

    @Override
    @Test(dataProvider = "loginCredentials")
    public void testLogin(String id, String username, String password) {

    }

    @Override
    @Test(dataProvider = "loginCredentials")
    public void testNewsletterSubscription(String id, String username, String password) {

    }

    @Override
    @Test(dataProvider = "loginCredentials")
    public void testSaveFunctionality(String id, String login, String password) {

    }
}
