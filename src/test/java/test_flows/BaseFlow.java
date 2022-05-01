package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.page_objects.LoginScreen;

public class BaseFlow {
    private final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void goToLoginScreen(){
        new LoginScreen(appiumDriver).botomNavComponent().clickOnLoginIcon();
    }
}
