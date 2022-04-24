package test.lesson_17;

import context.Context;
import context.waitMoreThanContext;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TakingScreenshot {
    public static void main(String[] args) {
        // Get appium Driver
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            // Find and click
            MobileElement webViewNavBtnSel = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            webViewNavBtnSel.click();

            // Whole screen
            File base64ScreenshotData = appiumDriver.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("HomeScreen.png");
            FileUtils.copyFile(base64ScreenshotData, new File(fileLocation));

            // An area
            MobileElement loginFormElm = appiumDriver.findElement(MobileBy.AccessibilityId("Login-screen"));
            File base64LoginForm = loginFormElm.getScreenshotAs(OutputType.FILE);
            String loginFormFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginForm.png");
            FileUtils.copyFile(base64LoginForm, new File(loginFormFileLocation));

            // An element
            MobileElement loginBtnElm = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            File base64LoginBtn = loginBtnElm.getScreenshotAs(OutputType.FILE);
            String loginBthFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginButton.png");
            FileUtils.copyFile(base64LoginBtn, new File(loginBthFileLocation));

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
