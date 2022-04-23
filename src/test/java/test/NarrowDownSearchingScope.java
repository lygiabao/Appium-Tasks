package test;

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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NarrowDownSearchingScope {
    public static void main(String[] args) {
        // Get appium Driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            // Get mobile Window Size
            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            // Calculate touch points
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 0;
            int yEndPoint = 50 * screenHeight / 100;

            // Convert coordinates option
            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            // Using touch option to swipe
            TouchAction touchAction = new TouchAction(driver);
            touchAction
                    .press(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            Map<String, String> notifications = new HashMap<String, String>();
            List<MobileElement> notifElements = driver.findElements(MobileBy.xpath("com.android.systemui:id/backgroundNormal"));
            for (MobileElement notifElement : notifElements) {
                MobileElement tittleElem = notifElement.findElement(MobileBy.id("android:id/title"));
                String tittleText = tittleElem.getText();
                MobileElement contentElem = notifElement.findElement(MobileBy.id("android:id/text"));
                String contentText = contentElem.getText();

                notifications.put(tittleText, contentText);
            }

            if (notifications.keySet().isEmpty()){
                throw new RuntimeException("[ERR] threre no notification to test");
            } else {
                for (String tittle : notifications.keySet()) {
                    System.out.println("Tittle: " + tittle);
                    System.out.println("Content: " + notifications.get(tittle));
                }
            }


            // Swipe up to dismiss notification bar
            touchAction
                    .longPress(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // Quit appium session
            driver.quit();
        }
    }
}
