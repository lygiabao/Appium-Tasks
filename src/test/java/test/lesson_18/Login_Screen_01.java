package test.lesson_18;

import driver.AppPackage;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.page_objects.LoginScreen;
import org.openqa.selenium.By;

import java.time.Duration;

public class Login_Screen_01 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            LoginScreen loginScreen = new LoginScreen(appiumDriver);
            // Login then input credentials -> click on login btn
            loginScreen.botomNavComponent().clickOnLoginIcon();

            // Fill the form
            loginScreen.loginFormComponent().inputUsername("a@gmail.com");
            loginScreen.loginFormComponent().inputPassword("123456789");
            loginScreen.loginFormComponent().clickOnLoginBtn();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}

