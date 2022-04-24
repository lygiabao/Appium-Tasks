package test.lesson_16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormInteraction {
    public static void main(String[] args) {
        // Get appium Driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            // Find and click
            MobileElement navLoginBtnElem = driver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            // Fill the form
            MobileElement usernameElem = driver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordElem = driver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBthElm = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            usernameElem.sendKeys("a@gmail.com");
            passwordElem.sendKeys("123456789");
            loginBthElm.click();

            // Get text from login dialog
            WebDriverWait wait = new WebDriverWait(driver, 5L);
            WebElement loginDialogTittle = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/message")));
            System.out.println(loginDialogTittle.getText());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // Quit appium session
            driver.quit();
        }
    }
}
