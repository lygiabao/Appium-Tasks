package test.lesson_16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormComponents {
    public static void main(String[] args) {
        // Get appium Driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            // Find and click
            MobileElement navLoginBtnElem = driver.findElement(MobileBy.AccessibilityId("Forms"));
            navLoginBtnElem.click();

            // Input field
            driver.findElement(MobileBy.AccessibilityId("text-input")).sendKeys("Bao");
            MobileElement typedInput = driver.findElement(MobileBy.AccessibilityId("input-text-result"));
            System.out.println(typedInput.getText());
            driver.findElement(MobileBy.AccessibilityId("switch")).click();
            MobileElement switchText = driver.findElement(MobileBy.AccessibilityId("switch-text"));
            System.out.println(switchText.getText());
            driver.findElement(MobileBy.xpath("//android.widget.EditText[contains(@text, \"Select an item...\")]")).click();

            // Wait until on form screen
            WebDriverWait wait = new WebDriverWait(driver, 5L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Appium is awesome\")")));

            driver.findElement(
                    MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Appium is awesome\")")).click();

            // Get mobile Window Size
            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            // Calculate touch points
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 50 * screenHeight / 100;
            int yEndPoint = 10 * screenHeight / 100;

            // Convert coordinates option
            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            // Using touch option to swipe
            TouchAction touchAction = new TouchAction(driver);
            touchAction
                    .longPress(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            // Click on active button
            driver.findElement(MobileBy.AccessibilityId("button-Active")).click();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // Quit appium session
            driver.quit();
        }
    }
}
