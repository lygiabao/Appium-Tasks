package context;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class waitMoreThanContext implements ExpectedCondition<Boolean> {

    private AppiumDriver<MobileElement> appiumDriver;
    public waitMoreThanContext(AppiumDriver<MobileElement> Driver) {
        this.appiumDriver = appiumDriver;
    }

    @NullableDecl
    public Boolean apply(WebDriver webDriver) {
        return appiumDriver.getContextHandles().size() > 1;
    }
}
