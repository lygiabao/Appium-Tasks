package test.lesson_18;

import driver.AppPackage;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.internal.CapabilityHelpers;
import models.page_objects.LoginScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

import java.time.Duration;

public class HandleMultipleApps {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            // Login then input credentials -> click on login btn
            MobileElement navLoginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            // Fill the form
            LoginScreen loginScreen = new LoginScreen(appiumDriver);
            MobileElement usernameElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBthElm = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            usernameElem.sendKeys("a@gmail.com");
            passwordElem.sendKeys("123456789");
            loginBthElm.click();

            // Click to background button
            appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

            // Turn wifi off || switch to another app
            appiumDriver.activateApp(AppPackage.settings);
            appiumDriver.findElement(By.xpath("//*[@text='Wi-Fi'] ")).click();
            //By wifiStatusSel = MobileBy.id("android:id/checkbox");

            // Trigger On/ Off network
            MobileElement wifiStatusElem = appiumDriver.findElement(MobileBy.id("android:id/checkbox"));
            String wifiStatusStr = wifiStatusElem.getText().trim();
            boolean wifiIsOn = wifiStatusStr.equalsIgnoreCase("on");
            if(wifiIsOn){
                wifiStatusElem.click();
            }

            // Switch to active app again
            appiumDriver.activateApp(AppPackage.wdio);
            appiumDriver.findElement(By.xpath("//*[@text='OK']")).click();
            Thread.sleep(2L);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
