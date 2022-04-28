package models.page_objects;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.BotomNavComponent;
import models.components.LoginFormComponent;
import org.openqa.selenium.By;

public class LoginScreen {
    private final AppiumDriver<MobileElement> driver;

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public LoginFormComponent loginFormComponent(){
        return new LoginFormComponent(driver);
    }

    public BotomNavComponent botomNavComponent(){
        return new BotomNavComponent(driver);
    }
}
