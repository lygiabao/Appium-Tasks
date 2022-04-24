package test.lesson_16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class XPATHLearning {
    public static void main(String[] args) {
        // Get appium Driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            // Find and click
            MobileElement navLoginBtnElem = driver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            // Find all matching Elements
            List<MobileElement> credInputFiled = driver.findElements(MobileBy.xpath("//android.widget.EditText"));
            final int USERNAME_TEXTBOX = 0;
            final int PASSWORD_TEXTBOX = 1;
            credInputFiled.get(USERNAME_TEXTBOX).sendKeys("bao@gmail.com");
            credInputFiled.get(PASSWORD_TEXTBOX).sendKeys("12345678");

            MobileElement loginButton = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"When the device\")"));
            System.out.println(loginButton.getText());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // Quit appium session
            driver.quit();
        }
    }
}
